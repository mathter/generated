package tech.generated.common.engine.spi.summner.path;


import tech.generated.common.Context;
import tech.generated.common.path.Path;
import tech.generated.common.path.Selector;

import java.util.function.BiPredicate;

public class CommonValueMatchSelector<T> extends AbstractSelector implements Cloneable {

    private final T value;

    private final BiPredicate<T, Path<?, ?>> matcher;

    public CommonValueMatchSelector(String name, Selector<Context<?>> parent, long metrics, BiPredicate<T, Path<?, ?>> matcher, T value) {
        super(name, parent, metrics);
        if (value == null) {
            throw new IllegalArgumentException("value can't be null!");
        }

        if (matcher == null) {
            throw new IllegalArgumentException("matcher can't be null!");
        }

        this.value = value;
        this.matcher = matcher;
    }

    public T getValue() {
        return this.value;
    }

    public BiPredicate<T, Path<?, ?>> getMatcher() {
        return matcher;
    }

    @Override
    public boolean test(Context<?> path) {
        return this.matcher.test(this.value, path) && super.test(path);
    }

    @Override
    public CommonValueMatchSelector<T> clone() throws CloneNotSupportedException {
        final CommonValueMatchSelector<T> clone = (CommonValueMatchSelector<T>) super.clone();

        return clone;
    }
}
