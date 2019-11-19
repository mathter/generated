package tech.generated.common.engine.spi.summner;

import tech.generated.common.Context;
import tech.generated.common.path.Selector;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface Core {
    public Collection<Selector<Context<?>>> instanceBuilderSelectors();

    public Function<Context<?>, ?> instanceBuilder(Selector<?> selector);

    public Collection<Selector<Context<?>>> filterSelectors();

    public <T> BiFunction<Context<?>, ?, ?> filler(Selector<?> selector);
}
