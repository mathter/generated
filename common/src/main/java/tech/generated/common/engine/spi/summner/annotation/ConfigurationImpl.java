/*
 * Generated - testing becomes easier
 *
 * Copyright (C) 2020 mathter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.generated.common.engine.spi.summner.annotation;

import tech.generated.common.Context;
import tech.generated.common.engine.spi.Util;
import tech.generated.common.engine.spi.summner.configuration.Configuration;
import tech.generated.common.engine.spi.summner.DefaultFiller;
import tech.generated.common.engine.spi.summner.DefaultInstanceBuilder;
import tech.generated.common.engine.spi.summner.ValueContext;
import tech.generated.common.engine.spi.summner.selector.AsBoxed;
import tech.generated.common.path.Selector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class ConfigurationImpl implements Configuration {
    private final Map instanceBuilders = new HashMap<>();

    private final Map fillers = new HashMap<>();

    public void add(Selector<Context<?>> selector, Function<Context<?>, ?> function) {
        this.instanceBuilders.put(selector, function);
    }

    public void add(Selector<Context<?>> selector, BiFunction<Context<?>, ?, ?> function) {
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

    @Override
    public <T> Function<T, T> filler(Context<T> context) {
        final Collection<Selector<Context<?>>> candidates = new ArrayList<>();

        for (Selector<Context<?>> selector : this.filterSelectors()) {
            if (selector.test(context)) {
                candidates.add(selector);
            }
        }

        if (Util.isBoxing(context.clazz()) && candidates.isEmpty()) {
            for (Selector<Context<?>> selector : this.filterSelectors()) {
                if (selector instanceof AsBoxed && ((AsBoxed<Selector<Context<?>>>) selector).boxed().test(context)) {
                    candidates.add(selector);
                }
            }
        }

        return candidates
                .stream()
                .max(Comparator.comparing(Selector::metrics))
                .map(s -> {
                    BiFunction<Context<T>, T, T> f = this.filler(s);

                    Function<T, T> function = (T o) -> f.apply(context, o);

                    return function;
                })
                .orElse(new DefaultFiller<T>((ValueContext<T>) context));
    }

    @Override
    public <T> Function<T, T> defaultFiller(Context<T> context) {
        return new DefaultFiller<T>((ValueContext<T>) context);
    }

    @Override
    public <T> Supplier<T> builder(Context<T> context) {
        final Collection<Selector<Context<?>>> candidates = new ArrayList<>();

        for (Selector<Context<?>> selector : this.instanceBuilderSelectors()) {
            if (selector.test(context)) {
                candidates.add(selector);
            }
        }

        if (Util.isBoxing(context.clazz()) && candidates.isEmpty()) {
            for (Selector<Context<?>> selector : this.instanceBuilderSelectors()) {
                if (selector instanceof AsBoxed && ((AsBoxed<Selector<Context<?>>>) selector).boxed().test(context)) {
                    candidates.add(selector);
                }
            }
        }

        return candidates
                .stream()
                .max(Comparator.comparing(Selector::metrics))
                .map(s -> {
                    Function<Context<T>, T> function = this.instanceBuilder(s);

                    return (Supplier<T>) () -> (T) function.apply(context);
                })
                .orElse(new DefaultInstanceBuilder(context.clazz()));
    }
}
