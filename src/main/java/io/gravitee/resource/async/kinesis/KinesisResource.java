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

import io.gravitee.resource.api.AbstractConfigurableResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class KinesisResource extends AbstractConfigurableResource<KinesisResourceConfiguration> {

    private final Logger LOGGER = LoggerFactory.getLogger(KinesisResource.class);

    @Override
    protected void doStart() throws Exception{
        super.doStart();
        LOGGER.info("Start: " + configuration().getStringParam());
    }

    @Override
    protected void doStop() throws Exception{
        super.doStop();
        LOGGER.info("Stop: " + configuration().getStringParam());
    }
}
