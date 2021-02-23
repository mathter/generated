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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.generated.ObjectFactory;
import tech.generated.ObjectFactoryProducer;
import tech.generated.configuration.dsl.DefaultConfiguration;
import tech.generated.configuration.dsl.DslFactory;

public class ObjectFactoryTest {

    @Test
    public void createObjectFactory() {
        final ObjectFactoryProducer producer = ObjectFactoryProducer.producer(tech.generated.ObjectFactoryProducer.DEFAULT_FACTORY);
        Assertions.assertNotNull(producer);

        final ObjectFactory objectFactory = producer.factory(new DefaultConfiguration(DslFactory.dsl()));
        Assertions.assertNotNull(objectFactory);
    }
}
