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
