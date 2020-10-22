package tech.generated.common.engine.spi.summner.dsl;

import tech.generated.common.dsl.Selector;

class Strict<T> extends AbstractSelector implements tech.generated.common.dsl.Strict<T> {
    private final T clazz;

    Strict(T clazz, Selector prev) {
        super(prev);
        this.clazz = clazz;
    }
}
