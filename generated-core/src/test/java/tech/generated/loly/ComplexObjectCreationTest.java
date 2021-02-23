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
    public void testOneLevel() {
        Person value = objectFactory.build(Person.class);

        Assertions.assertNotNull(value);
    }

    @Test
    public void testTwoLevel() {
        Composite value = objectFactory.build(Composite.class);

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
