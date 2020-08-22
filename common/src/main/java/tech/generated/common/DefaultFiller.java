package tech.generated.common;

import tech.generated.common.engine.spi.summner.ValueContext;

import java.util.function.Function;

/**
 * Default filler for using in custom configuration.
 *
 * @param <T> type of object.
 * @see tech.generated.common.annotation.DefaultConfiguration
 */
public class DefaultFiller<T> implements Function<T, T> {
    private final Function<T, T> inner;

    public DefaultFiller(Context<?> context) {
        // Using default filler of <em>Summer</em> generated engine.
        this.inner = new tech.generated.common.engine.spi.summner.DefaultFiller((ValueContext<?>) context);
    }

    @Override
    public T apply(T object) {
        return this.inner.apply(object);
    }
}
