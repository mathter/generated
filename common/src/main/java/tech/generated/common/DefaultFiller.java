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

    public DefaultFiller(Context<T> context) {
        // Using default filler of <em>Summer</em> generated engine.
        final GeneratedEngine engine = context.getGeneratedEngine();
        final FillerFactory fillerFactory = engine.fillerFactory();

        this.inner = fillerFactory.defaultFiller(context);
    }

    @Override
    public T apply(T object) {
        return this.inner.apply(object);
    }
}
