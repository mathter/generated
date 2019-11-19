package tech.generated.examples;

import tech.generated.common.GeneratedEngine;
import tech.generated.common.GeneratedEngineFactory;
import tech.generated.common.Init;
import tech.generated.common.ObjectFactory;

public class SimpleBoxingTypeGeneration {
    public static void main(String[] args) {
        GeneratedEngine engine = GeneratedEngineFactory.newInstance(null);
        ObjectFactory objectFactory = engine.objectFactory();

        int value = objectFactory.build(Init.builder(int.class).build());
        System.out.println(value);

        Integer value2 = objectFactory.build(Init.builder(Integer.class).build());
        System.out.println(value2);
    }
}
