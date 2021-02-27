package tech.generated.loly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tech.generated.ObjectFactory;
import tech.generated.ObjectFactoryProducer;
import tech.generated.configuration.dsl.DefaultConfiguration;
import tech.generated.configuration.dsl.DslFactory;

import java.util.UUID;

public class ComplexObjectCreationTest {
    private static ObjectFactory OBJECT_FACTORY;

    @BeforeAll
    private static void init() {
        OBJECT_FACTORY = ObjectFactoryProducer
                .producer()
                .factory(
                        new DefaultConfiguration(
                                DslFactory.dsl()
                        )
                );
    }

    @Test
    public void testOneLevel() {
        Person value = OBJECT_FACTORY.build(Person.class);

        Assertions.assertNotNull(value);
    }

    @Test
    public void testTwoLevel() {
        Composite value = OBJECT_FACTORY.build(Composite.class);

        Assertions.assertNotNull(value);
    }

    public static class Person {

        private UUID uuid;

        private String name;

        private String lastName;
    }

    public static class Composite {

        private UUID uuid;

        private Person person;
    }
}
