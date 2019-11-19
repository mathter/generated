package tech.generated.common.engine.spi.summner.path;


import tech.generated.common.Context;
import tech.generated.common.path.Path;
import tech.generated.common.path.Selector;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class ValueEqualsSelector<T> extends CommonValueMatchSelector<T> {
    public ValueEqualsSelector(String name, Selector<Context<?>> parent, long metrics, Function<Path<?, ?>, T> getter, T value) {
        super(name, parent, metrics, new BiPredicate<T, Path<?, ?>>() {
            @Override
            public boolean test(T value, Path<?, ?> path) {
                return Objects.equals(value, path.node());
            }
        }, value);
    }
}
