package tech.generated.examples;

import tech.generated.common.Context;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.GeneratedEngineFactory;
import tech.generated.common.ObjectFactory;
import tech.generated.common.annotation.DefaultConfiguration;
import tech.generated.common.annotation.Filler;
import tech.generated.common.annotation.InstanceBuilder;

import java.util.Date;

public class ForClassAnnotationUsing {
    static class CustomConfiguration extends DefaultConfiguration {
        @InstanceBuilder(simple = true)
        public Person personeInstance(Context ctx) {
            return new Person();
        }

        @Filler
        public Person personFiller(Person object) {
            object.setName("Name");
            object.setMiddleName("MiddleName");
            object.setLastName("LastName");
            object.setBirthday(new Date());

            return object;
        }
    }

    public static void main(String[] args) {
        GeneratedEngine engine = GeneratedEngineFactory.newInstance(null, new ForClassAnnotationUsing.CustomConfiguration());
        ObjectFactory objectFactory = engine.objectFactory();

        Person object = objectFactory.build(Person.class);

        System.out.println(object);
    }
}
