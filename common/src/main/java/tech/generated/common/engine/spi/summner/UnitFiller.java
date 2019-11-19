package tech.generated.common.engine.spi.summner;

import java.util.function.Function;

/**
 * Unit filler. Return origin object.
 *
 * @param <T> type of object which will be filled.
 */
public class UnitFiller<T> implements Function<T, T> {
    @Override
    public T apply(T object) {
        return object;
    }
}
