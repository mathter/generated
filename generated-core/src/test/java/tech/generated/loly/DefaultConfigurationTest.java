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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tech.generated.ObjectFactory;
import tech.generated.ObjectFactoryProducer;
import tech.generated.configuration.dsl.DefaultConfiguration;
import tech.generated.configuration.dsl.DslFactory;

import java.util.Date;
import java.util.UUID;

public class DefaultConfigurationTest {

    private static ObjectFactory objectFactory;

    @BeforeAll
    private static void init() {
        objectFactory = ObjectFactoryProducer
                .producer()
                .factory(
                        new DefaultConfiguration(
                                DslFactory.dsl()
                        )
                );
    }

    @Test
    public void testbyte() {
        Byte value = this.objectFactory.build(byte.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testByte() {
        Byte value = this.objectFactory.build(Byte.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testshort() {
        Short value = this.objectFactory.build(short.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testShort() {
        Short value = this.objectFactory.build(Short.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testInt() {
        Integer value = this.objectFactory.build(int.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testInteger() {
        Integer value = this.objectFactory.build(Integer.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testlong() {
        Long value = this.objectFactory.build(long.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testLong() {
        Long value = this.objectFactory.build(Long.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testfloat() {
        Float value = this.objectFactory.build(float.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testFloat() {
        Float value = this.objectFactory.build(Float.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testdouble() {
        Double value = this.objectFactory.build(double.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testDouble() {
        Double value = this.objectFactory.build(Double.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testString() {
        String value = this.objectFactory.build(String.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testUuid() {
        UUID value = this.objectFactory.build(UUID.class);
        Assertions.assertNotNull(value);
    }

    @Test
    public void testDate() {
        Date value = this.objectFactory.build(Date.class);
        Assertions.assertNotNull(value);
    }
}
