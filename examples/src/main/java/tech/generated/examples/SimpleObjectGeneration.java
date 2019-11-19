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

import tech.generated.common.GeneratedEngine;
import tech.generated.common.GeneratedEngineFactory;
import tech.generated.common.Init;
import tech.generated.common.ObjectFactory;

import java.util.UUID;

public class SimpleObjectGeneration {
    public static void main(String[] args) {
        GeneratedEngine engine = GeneratedEngineFactory.newInstance(null);
        ObjectFactory objectFactory = engine.objectFactory();
        A value = objectFactory.build(Init.builder(A.class).build());

        System.out.println(value);
    }
}

class A {
    private String name;

    private B b;
}

class B {
    private int count;

    private String ref;

    private UUID uuid;
}
