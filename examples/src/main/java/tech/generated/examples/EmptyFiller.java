package tech.generated.examples;

import tech.generated.common.Context;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.GeneratedEngineFactory;
import tech.generated.common.ObjectFactory;
import tech.generated.common.annotation.DefaultConfiguration;
import tech.generated.common.annotation.InstanceBuilder;

import java.util.Calendar;

public class EmptyFiller {
    static class CustomConfiguration extends DefaultConfiguration {
        @InstanceBuilder(simple = true)
        public Person personeInstance(Context ctx) {
            Person object = new Person();
            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.MONTH, Calendar.MARCH);
            calendar.set(Calendar.YEAR, 2000);

            object.setName("Name");
            object.setMiddleName("MiddleName");
            object.setLastName("LastName");
            object.setBirthday(calendar.getTime());

            return object;
        }
    }

    public static void main(String[] args) {
        GeneratedEngine engine = GeneratedEngineFactory.newInstance(null, new CustomConfiguration());
        ObjectFactory objectFactory = engine.objectFactory();

        Person object = objectFactory.build(Person.class);

        System.out.println(object);
    }
}
