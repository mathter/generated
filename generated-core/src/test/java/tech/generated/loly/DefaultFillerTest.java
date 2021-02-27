package tech.generated.loly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.generated.Context;
import tech.generated.Filler;
import tech.generated.ObjectFactory;
import tech.generated.ObjectFactoryProducer;
import tech.generated.configuration.dsl.DefaultConfiguration;

import java.util.Date;
import java.util.UUID;

public class DefaultFillerTest {

    @Test
    public void test() {
        ObjectFactory objectFactory = ObjectFactoryProducer
                .producer()
                .factory(new DefaultConfiguration() {
                    {
                        reg(
                                strict(A.class).defaultFiller()
                        );
                    }
                });

        A value = objectFactory.build(A.class);

        Assertions.assertNotNull(value.uuid);
        Assertions.assertNotNull(value.name);
        Assertions.assertNotNull(value.lastName);
        Assertions.assertNotNull(value.birthDate);
    }

    @Test
    public void testIncluding() {
        ObjectFactory objectFactory = ObjectFactoryProducer
                .producer()
                .factory(new DefaultConfiguration() {
                    {
                        reg(
                                strict(A.class)
                                        .defaultFiller().including("name")
                        );
                    }
                });

        A value = objectFactory.build(A.class);

        Assertions.assertNull(value.uuid);
        Assertions.assertNotNull(value.name);
        Assertions.assertNull(value.lastName);
        Assertions.assertNull(value.birthDate);
    }

    @Test
    public void testCustom() {
        ObjectFactory objectFactory = ObjectFactoryProducer
                .producer()
                .factory(new DefaultConfiguration() {
                    {
                        reg(
                                strict(A.class)
                                        .defaultFiller()
                                        .excluding("name")
                                        .custom(new Filler<A>() {
                                            @Override
                                            public A apply(Context<A> context, A a) {
                                                a.name = "John";
                                                return a;
                                            }
                                        })
                        );
                    }
                });

        A value = objectFactory.build(A.class);

        Assertions.assertNotNull(value.uuid);
        Assertions.assertEquals("John", value.name);
        Assertions.assertNotNull(value.lastName);
        Assertions.assertNotNull(value.birthDate);
    }

    @Test
    public void testExcluding() {
        ObjectFactory objectFactory = ObjectFactoryProducer
                .producer()
                .factory(new DefaultConfiguration() {
                    {
                        reg(
                                strict(A.class)
                                        .defaultFiller().excluding("name")
                        );
                    }
                });

        A value = objectFactory.build(A.class);

        Assertions.assertNotNull(value.uuid);
        Assertions.assertNull(value.name);
        Assertions.assertNotNull(value.lastName);
        Assertions.assertNotNull(value.birthDate);
    }

    private static class A {
        private UUID uuid;

        private String name;

        private String lastName;

        private Date birthDate;
    }
}
