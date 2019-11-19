package tech.generated.common.engine.spi.summner;

import tech.generated.common.util.Util;

import java.util.function.Supplier;

public class DefaultInstanceBuilder<T> implements Supplier<T> {
    final Class<T> clazz;

    public DefaultInstanceBuilder(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T get() {
        return Util.newInstance(clazz);
    }
}
