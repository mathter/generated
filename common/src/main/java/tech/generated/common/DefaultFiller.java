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
package tech.generated.common;

import tech.generated.common.engine.spi.summner.ValueContext;

import java.util.function.Function;

/**
 * Default filler for using in custom configuration.
 *
 * @param <T> type of object.
 * @see tech.generated.common.annotation.DefaultConfiguration
 */
public class DefaultFiller<T> implements Function<T, T> {
    private final Function<T, T> inner;

    public DefaultFiller(Context<T> context) {
        // Using default filler of <em>Summer</em> generated engine.
        final GeneratedEngine engine = context.getGeneratedEngine();
        final FillerFactory fillerFactory = engine.fillerFactory();

        this.inner = fillerFactory.defaultFiller(context);
    }

    @Override
    public T apply(T object) {
        return this.inner.apply(object);
    }
}
