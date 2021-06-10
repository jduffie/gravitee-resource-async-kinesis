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

import io.gravitee.gateway.api.ExecutionContext;

public class KinesisResourceRuntimeConfigurationUtil {

    public static String decodeRegionName(ExecutionContext context, KinesisResourceConfiguration configuration) {
        return context.getTemplateEngine().getValue(configuration.getRegionName(), String.class);
    }

    public static String decodeStreamName(ExecutionContext context, KinesisResourceConfiguration configuration) {
        return context.getTemplateEngine().getValue(configuration.getStreamName(), String.class);
    }

    public static String decodeAwsSecretAccessKey(ExecutionContext context, KinesisResourceConfiguration configuration) {
        return context.getTemplateEngine().getValue(configuration.getAwsSecretAccessKey(), String.class);
    }

    public static String decodeAwsAccessKeyId(ExecutionContext context, KinesisResourceConfiguration configuration) {
        return context.getTemplateEngine().getValue(configuration.getAwsAccessKeyId(), String.class);
    }

    public static KinesisResourceRuntimeConfiguration getRuntimeConfiguration(
        ExecutionContext context,
        KinesisResourceConfiguration configuration
    ) {
        return KinesisResourceRuntimeConfiguration
            .builder()
            .scope(configuration.getScope())
            .regionName(decodeRegionName(context, configuration))
            .streamName(decodeStreamName(context, configuration))
            .awsAccessKeyId(decodeAwsAccessKeyId(context, configuration))
            .awsSecretAccessKey(decodeAwsSecretAccessKey(context, configuration))
            .build();
    }

    public static KinesisResourceRuntimeConfiguration getRuntimeConfiguration(KinesisResourceConfiguration configuration) {
        return KinesisResourceRuntimeConfiguration
            .builder()
            .scope(configuration.getScope())
            .regionName(configuration.getRegionName())
            .streamName(configuration.getStreamName())
            .awsAccessKeyId(configuration.getAwsAccessKeyId())
            .awsSecretAccessKey(configuration.getAwsSecretAccessKey())
            .build();
    }
}
