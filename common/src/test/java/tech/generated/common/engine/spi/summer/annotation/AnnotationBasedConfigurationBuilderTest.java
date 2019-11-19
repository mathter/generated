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
package tech.generated.common.engine.spi.summer.annotation;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.GeneratedEngineFactory;
import tech.generated.common.annotation.Filler;
import tech.generated.common.annotation.ForClass;
import tech.generated.common.annotation.InstanceBuilder;
import tech.generated.common.engine.spi.summner.Configuration;
import tech.generated.common.engine.spi.summner.annotation.AnnotationBasedConfigurationFactory;

public class AnnotationBasedConfigurationBuilderTest {
    @Test
    public void test() {
        final GeneratedEngine engine = GeneratedEngineFactory.newInstance(tech.generated.common.engine.spi.summner.GeneratedEngineFactory.NAME);
        final AnnotationBasedConfigurationFactory configurationFactory = new AnnotationBasedConfigurationFactory();

        Configuration configuration = configurationFactory.build(new Object() {
            @InstanceBuilder
            @Filler
            @ForClass(int.class)
            public Integer integer() {
                return RandomUtils.nextInt();
            }

            @ForClass(int.class)
            @Filler
            public Integer filler(int i) {
                return i;
            }

            @ForClass(value = Integer.class, strict = true)
            @Filler
            public Integer filler1(Integer i) {
                return i;
            }
        });

        Assert.assertNotNull(configuration);
    }
}
