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
