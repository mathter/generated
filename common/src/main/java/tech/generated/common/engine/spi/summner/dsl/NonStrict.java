package tech.generated.common.engine.spi.summner.dsl;

import tech.generated.common.dsl.Selector;

class NonStrict<T> extends AbstractSelector implements tech.generated.common.dsl.NonStrict<T> {
    private final T clazz;

    NonStrict(T clazz, Selector prev) {
        super(prev);
        this.clazz = clazz;
    }
}
