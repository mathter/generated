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
