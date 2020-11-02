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
package tech.generated.common.engine.spi.summner.dsl;

import tech.generated.common.Context;
import tech.generated.common.engine.spi.summner.configuration.Configuration;
import tech.generated.common.path.Selector;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConfigurationImpl implements Configuration {
    private final Map instanceBuilders = new HashMap<>();

    private final Map fillers = new HashMap<>();

    @Override
    public Collection<Selector<Context<?>>> instanceBuilderSelectors() {
        return null;
    }

    @Override
    public <T> Function<Context<T>, T> instanceBuilder(Selector<?> selector) {
        return null;
    }

    @Override
    public Collection<Selector<Context<?>>> filterSelectors() {
        return null;
    }

    @Override
    public <T> BiFunction<Context<T>, T, T> filler(Selector<?> selector) {
        return null;
    }

    @Override
    public <T> Function<T, T> filler(Context<T> context) {
        return null;
    }

    @Override
    public <T> Function<T, T> defaultFiller(Context<T> context) {
        return null;
    }

    @Override
    public <T> Supplier<T> builder(Context<T> context) {
        return null;
    }
}
