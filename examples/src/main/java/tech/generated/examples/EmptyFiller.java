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
