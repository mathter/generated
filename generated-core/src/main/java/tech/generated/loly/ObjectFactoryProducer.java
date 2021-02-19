/*
 * Generated - testing becomes easier
 *
 * Copyright (C) 2020 mathter@mail.ru
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
package tech.generated.loly;

import tech.generated.ObjectFactory;
import tech.generated.configuration.dsl.Configuration;
import tech.generated.configuration.dsl.DefaultConfiguration;
import tech.generated.configuration.dsl.DslFactory;

public class ObjectFactoryProducer extends tech.generated.ObjectFactoryProducer {
    private static final String ID = "loly";

    @Override
    public ObjectFactory factory(Object configuration) {
        final ObjectFactory objectFactory;

        if (configuration instanceof Configuration) {
            objectFactory = this.build(configuration);
        } else {
            objectFactory = this.factory(new DefaultConfiguration(DslFactory.dsl()));
        }

        return objectFactory;
    }

    private ObjectFactory build(Object configuration) {
        return new tech.generated.loly.ObjectFactory(BConfiguration.build((Configuration) configuration));
    }

    @Override
    protected String id() {
        return ID;
    }
}
