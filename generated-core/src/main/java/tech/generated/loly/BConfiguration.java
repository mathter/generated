/*
 * Generated - testing becomes easier
 *
 * Copyright (C) 2020 mathter@mail.ru
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
package tech.generated.loly;

import org.apache.commons.lang3.tuple.Pair;
import tech.generated.Filler;
import tech.generated.InstanceBuilder;
import tech.generated.configuration.dsl.Configuration;
import tech.generated.configuration.dsl.Custom;
import tech.generated.configuration.dsl.NonStrict;
import tech.generated.configuration.dsl.Path;
import tech.generated.configuration.dsl.Selectable;
import tech.generated.configuration.dsl.Strict;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

final class BConfiguration {

    private final Collection<Selector> instanceBuilderSelectors;

    private final Map<Selector, InstanceBuilder<?>> instanceBuilderMap;

    private final Collection<Selector> fillerSelectors;

    private final Map<Selector, Filler<?>> fillerMap;

    private BConfiguration(Map<Selector, InstanceBuilder<?>> instanceBuilderMap, Map<Selector, Filler<?>> fillerMap) {
        this.instanceBuilderMap = Collections.unmodifiableMap(Objects.requireNonNull(instanceBuilderMap));
        this.instanceBuilderSelectors = Collections.unmodifiableCollection(this.instanceBuilderMap.keySet());

        this.fillerMap = Collections.unmodifiableMap(Objects.requireNonNull(fillerMap));
        this.fillerSelectors = Collections.unmodifiableCollection(this.fillerMap.keySet());
    }

    public static BConfiguration build(Configuration configuration) {
        final Map<Selector, InstanceBuilder<?>> instanceBuilderMap = new HashMap<>();
        final Map<Selector, Filler<?>> fillerMap = new HashMap<>();

        Objects.requireNonNull(configuration)
                .selectables()
                .stream()
                .map(BConfiguration::selectable)
                .forEach(e -> {
                    final Object right = e.getRight();

                    if (right instanceof InstanceBuilder) {
                        instanceBuilderMap.put(e.getLeft(), (InstanceBuilder) right);
                    } else if (right instanceof Filler) {
                        fillerMap.put(e.getLeft(), (Filler) right);
                    } else {
                        throw new IllegalArgumentException("Invalid entity: " + right);
                    }
                });

        return new BConfiguration(instanceBuilderMap, fillerMap);
    }

    private static Pair<Selector, Object> selectable(Selectable selectable) {
        final Object function = selectable.function();
        final Selector selector = selector(selectable.selector());

        return Pair.of(selector, function);
    }

    private static Selector selector(tech.generated.configuration.dsl.Selector selector) {
        final Selector result;

        if (selector != null) {
            result = selector(selector, selector(selector.next()));
        } else {
            result = null;
        }

        return result;
    }

    private static Selector selector(tech.generated.configuration.dsl.Selector selector, Selector next) {
        final Selector result;

        if (selector instanceof Strict) {
            result = new StrictClassSelector(selector.name(), selector.metrics(), next, ((Strict<?>) selector).clazz());
        } else if (selector instanceof NonStrict) {
            result = new NonStrictClassSelector(selector.name(), selector.metrics(), next, ((NonStrict<?>) selector).clazz());
        } else if (selector instanceof Custom) {
            result = new CustomSelector(selector.name(), selector.metrics(), next, (Custom) selector);
        } else if (selector instanceof Path) {
            result = PathSelectorBuilder.build(selector, next);
        } else {
            throw new IllegalArgumentException("'" + selector + "' is illegal selector!");
        }

        return result;
    }
}
