/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.resource.async.kinesis;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.kinesis.producer.KinesisProducer;
import com.amazonaws.services.kinesis.producer.KinesisProducerConfiguration;
import com.amazonaws.services.kinesis.producer.UserRecordResult;
import io.gravitee.gateway.api.handler.Handler;
import io.gravitee.resource.async.api.AsyncHash;
import io.gravitee.resource.async.api.AsyncMessage;
import io.gravitee.resource.async.api.AsyncResource;
import io.gravitee.resource.async.api.AsyncResourceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class KinesisResource extends AsyncResource<KinesisResourceConfiguration, UserRecordResult> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KinesisResource.class);

    private KinesisProducer kinesisProducer;
    private KinesisResourceRuntimeConfiguration runtimeConfiguration;

    @Override
    protected void doStart() throws Exception {
        super.doStart();
        LOGGER.info("Initializing resource");
        this.runtimeConfiguration = KinesisResourceRuntimeConfigurationUtil.getRuntimeConfiguration(null, configuration());
        this.kinesisProducer = createProducer(this.runtimeConfiguration);
    }

    @Override
    protected void doStop() throws Exception {
        super.doStop();
        LOGGER.info("Destroying resource");
    }

    @Override
    public void publish(AsyncMessage asyncMessage, AsyncHash asyncHash, Handler<AsyncResourceResult> handler) {
        LOGGER.info("publishing");
    }

    private static KinesisProducer createProducer(KinesisResourceRuntimeConfiguration kinesisPolicyConfiguration) {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(
            kinesisPolicyConfiguration.getAwsAccessKeyId(),
            kinesisPolicyConfiguration.getAwsSecretAccessKey()
        );
        KinesisProducerConfiguration kinesisProducerConfiguration = new KinesisProducerConfiguration();
        kinesisProducerConfiguration
            .setRegion(kinesisPolicyConfiguration.getRegionName())
            .setCredentialsProvider(new AWSStaticCredentialsProvider(awsCreds));
        return new KinesisProducer(kinesisProducerConfiguration);
    }
}
