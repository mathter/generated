package tech.generated.examples;

import tech.generated.common.GeneratedEngine;
import tech.generated.common.GeneratedEngineFactory;
import tech.generated.common.Init;
import tech.generated.common.ObjectFactory;

public class SimpleStringGeneration {
    public static void main(String[] args) {
        GeneratedEngine engine = GeneratedEngineFactory.newInstance(null);
        ObjectFactory objectFactory = engine.objectFactory();
        String value = objectFactory.build(Init.builder(String.class).build());

        System.out.println(value);
    }
}
