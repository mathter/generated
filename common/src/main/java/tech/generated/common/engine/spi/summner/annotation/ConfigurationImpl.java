package tech.generated.common.engine.spi.summner.annotation;

import tech.generated.common.Context;
import tech.generated.common.engine.spi.summner.Configuration;
import tech.generated.common.path.Selector;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

class ConfigurationImpl implements Configuration {
    private final Map instanceBuilders = new HashMap<>();

    private final Map fillers = new HashMap<>();

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
    public <T> Function<Context<T>, T> instanceBuilder(Selector<?> selector) {
        return (Function<Context<T>, T>) this.instanceBuilders.get(selector);
    }

    @Override
    public Collection<Selector<Context<?>>> filterSelectors() {
        return this.fillers.keySet();
    }

    @Override
    public <T> BiFunction<Context<T>, T, T> filler(Selector<?> selector) {
        return (BiFunction<Context<T>, T, T>) this.fillers.get(selector);
    }
}
