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

import io.gravitee.resource.api.ResourceConfiguration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KinesisResourceRuntimeConfiguration implements ResourceConfiguration {

    private PolicyScope scope = PolicyScope.REQUEST;
    private String streamName;
    private String regionName;
    private String awsAccessKeyId;
    private String awsSecretAccessKey;

    @Override
    public String toString() {
        return (
            "KinesisResourceConfiguration{" +
            "scope=" +
            this.getScope() +
            ", streamName='" +
            this.getStreamName() +
            '\'' +
            ", regionName='" +
            this.getRegionName() +
            '\'' +
            ", awsAccessKeyId='" +
            this.getAwsAccessKeyId().substring(0, 3) +
            '\'' +
            // TODO: nuke this once we validate the plugin configuration from browser
            ", awsSecretAccessKey='" +
            this.getAwsSecretAccessKey() +
            '\'' +
            '}'
        );
    }

    public PolicyScope getScope() {
        return scope;
    }

    public void setScope(PolicyScope scope) {
        this.scope = scope;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getAwsAccessKeyId() {
        return awsAccessKeyId;
    }

    public void setAwsAccessKeyId(String awsAccessKeyId) {
        this.awsAccessKeyId = awsAccessKeyId;
    }

    public String getAwsSecretAccessKey() {
        return awsSecretAccessKey;
    }

    public void setAwsSecretAccessKey(String awsSecretAccessKey) {
        this.awsSecretAccessKey = awsSecretAccessKey;
    }
}
