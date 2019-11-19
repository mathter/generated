package tech.generated.common.engine.spi.summner.annotation;

import tech.generated.common.Context;
import tech.generated.common.engine.spi.summner.Core;
import tech.generated.common.path.Selector;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

class CoreImpl implements Core {
    private final Map<Selector<Context<?>>, Function<Context<?>, ?>> instanceBuilders = new HashMap<>();

    private final Map<Selector<Context<?>>, BiFunction<Context<?>, ?, ?>> fillers = new HashMap<>();

    void add(Selector<Context<?>> selector, Function<Context<?>, ?> function) {
        this.instanceBuilders.put(selector, function);
    }

    void add(Selector<Context<?>> selector, BiFunction<Context<?>, ?, ?> function) {
        this.fillers.put(selector, function);
    }

    @Override
    public Collection<Selector<Context<?>>> instanceBuilderSelectors() {
        return this.instanceBuilders.keySet();
    }

    @Override
    public Function<Context<?>, ?> instanceBuilder(Selector<?> selector) {
        return this.instanceBuilders.get(selector);
    }

    @Override
    public Collection<Selector<Context<?>>> filterSelectors() {
        return this.fillers.keySet();
    }

    @Override
    public <T> BiFunction<Context<?>, ?, ?> filler(Selector<?> selector) {
        return this.fillers.get(selector);
    }
}
