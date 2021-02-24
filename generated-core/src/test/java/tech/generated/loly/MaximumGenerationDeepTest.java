package tech.generated.loly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tech.generated.ObjectFactory;
import tech.generated.ObjectFactoryProducer;
import tech.generated.configuration.dsl.AbstractConfiguration;
import tech.generated.configuration.dsl.DefaultConfiguration;
import tech.generated.configuration.dsl.DslFactory;

import java.util.UUID;

public class MaximumGenerationDeepTest {
    private static ObjectFactory objectFactory;

    @BeforeAll
    private static void init() {
        objectFactory = ObjectFactoryProducer
                .producer()
                .factory(
                        new AbstractConfiguration() {
                            @Override
                            public int maxGenerationDeep() {
                                return 10;
                            }
                        }
                );
    }

    @Test
    public void testOneLevel() {
        A value = objectFactory.build(A.class);

        Assertions.assertNotNull(value);
    }

    public static class A {
        private A a;
    }
}
