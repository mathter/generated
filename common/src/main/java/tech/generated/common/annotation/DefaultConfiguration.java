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
package tech.generated.common.annotation;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Date;
import java.util.UUID;

public class DefaultConfiguration {

    @ForClass(boolean.class)
    @InstanceBuilder
    public boolean booleanInstanceBuilder() {
        return RandomUtils.nextBoolean();
    }

    @ForClass(byte.class)
    @InstanceBuilder
    public byte byteInstanceBuilder() {
        return RandomUtils.nextBytes(1)[0];
    }

    @ForClass(short.class)
    @InstanceBuilder
    public short shortInstanceBuilder() {
        return (short) RandomUtils.nextInt();
    }

    @ForClass(int.class)
    @InstanceBuilder
    public int intInstanceBuilder() {
        return RandomUtils.nextInt();
    }

    @ForClass(long.class)
    @InstanceBuilder
    public long longInstanceBuilder() {
        return RandomUtils.nextLong();
    }

    @ForClass(float.class)
    @InstanceBuilder
    public float floatInstanceBuilder() {
        return RandomUtils.nextFloat();
    }

    @ForClass(double.class)
    @InstanceBuilder
    public double doubleInstanceBuilder() {
        return RandomUtils.nextDouble();
    }

    @ForClass(String.class)
    @InstanceBuilder
    public String stringInstanceBuilder() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    @ForClass(String.class)
    @InstanceBuilder
    public String stringInstanceBuilder1() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    @ForClass(UUID.class)
    @InstanceBuilder
    public UUID uuidInstanceBuilder() {
        return UUID.randomUUID();
    }

    @ForClass(Date.class)
    @InstanceBuilder(simple = true)
    public Date dateInstanceBuilder() {
        return new Date();
    }
}
