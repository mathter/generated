/*
 * Generated - testing becomes easier
 *
 * Copyright (C) 2020 mathter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.generated.common.engine.spi.summner;

import tech.generated.common.annotation.DefaultConfiguration;
import tech.generated.common.dsl.Dsl;
import tech.generated.common.engine.spi.summner.annotation.AnnotationBasedConfigurationFactory;
import tech.generated.common.engine.spi.summner.configuration.Configuration;

class GeneratedEngine implements tech.generated.common.GeneratedEngine {
    private final Configuration configuration;

    public GeneratedEngine(Object[] params) {
        if (params == null || params.length == 0) {
            this.configuration = new AnnotationBasedConfigurationFactory().build(new DefaultConfiguration());
        } else {
            this.configuration = new AnnotationBasedConfigurationFactory().build(params[0]);
        }
    }

    @Override
    public tech.generated.common.ObjectFactory objectFactory() {
        return new ObjectFactory(this);
    }

    @Override
    public tech.generated.common.InstanceBuilderFactory instanceBuilderFactory() {
        return this.configuration;
    }

    @Override
    public tech.generated.common.FillerFactory fillerFactory() {
        return this.configuration;
    }

    @Override
    public Dsl dsl() {
        return new tech.generated.common.engine.spi.summner.dsl.Dsl(this);
    }

    Configuration getConfiguration() {
        return configuration;
    }
}
