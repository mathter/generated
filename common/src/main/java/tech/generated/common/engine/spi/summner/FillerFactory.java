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
package tech.generated.common.engine.spi.summner;

import tech.generated.common.Context;
import tech.generated.common.engine.spi.summner.path.AsBoxed;
import tech.generated.common.path.Selector;
import tech.generated.common.util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

class FillerFactory implements tech.generated.common.FillerFactory {
    private final GeneratedEngine generatedEngine;

    FillerFactory(GeneratedEngine generatedEngine) {
        this.generatedEngine = generatedEngine;
    }

    @Override
    public <T> Function<T, T> filler(final Context<T> context) {
        final Collection<Selector<Context<?>>> candidates = new ArrayList<>();

        for (Selector<Context<?>> selector : this.generatedEngine.getCore().filterSelectors()) {
            if (selector.test(context)) {
                candidates.add(selector);
            }
        }

        if (Util.isBoxing(context.clazz()) && candidates.isEmpty()) {
            for (Selector<Context<?>> selector : this.generatedEngine.getCore().filterSelectors()) {
                if (selector instanceof AsBoxed && ((AsBoxed<Selector<Context<?>>>) selector).boxed().test(context)) {
                    candidates.add(selector);
                }
            }
        }

        return candidates
                .stream()
                .max(Comparator.comparing(Selector::metrics))
                .map(s -> {
                    BiFunction<Context<T>, T, T> f = this.generatedEngine.getCore().filler(s);

                    Function<T, T> function = (T o) -> f.apply(context, o);

                    return function;
                })
                .orElse(new DefaultFiller<T>((ValueContext<T>) context));

    }

    @Override
    public <T> Function<T, T> defaultFiller(Context<T> context) {
        return new DefaultFiller<T>((ValueContext<T>) context);
    }
}