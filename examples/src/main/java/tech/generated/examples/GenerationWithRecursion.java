package tech.generated.examples;

import tech.generated.common.Context;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.GeneratedEngineFactory;
import tech.generated.common.ObjectFactory;
import tech.generated.common.annotation.DefaultConfiguration;
import tech.generated.common.annotation.Filler;
import tech.generated.common.engine.spi.summner.DefaultFiller;
import tech.generated.common.engine.spi.summner.ValueContext;

public class GenerationWithRecursion {
    public static void main(String[] args) {
        GeneratedEngine engine = GeneratedEngineFactory.newInstance(
                null,
                new DefaultConfiguration() {
                    final int DEEP = 10;

                    @Filler
                    public WithRecursion filler(WithRecursion object, ValueContext context) {
                        if (context.stream().count() < DEEP) {
                            new DefaultFiller<>(context)
                                    .apply(object);
                        }

                        return object;
                    }
                });

        ObjectFactory objectFactory = engine.objectFactory();

        WithRecursion object = objectFactory.build(WithRecursion.class);

        System.out.println(object);
    }
}

class WithRecursion {
    private WithRecursion parent;

    @Override
    public String toString() {
        return new StringBuilder("WithRecursion[parent=").append(this.parent).append(']').toString();
    }
}