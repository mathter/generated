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
package tech.generated.common.engine.spi.summner.selector;


import tech.generated.common.Context;
import tech.generated.common.path.Path;
import tech.generated.common.path.Selector;

import java.util.function.BiPredicate;

public class ChainValueMatchSelector<T> extends AbstractChainSelector {

    private final T value;

    private final BiPredicate<T, Path<?, ?>> matcher;

    public ChainValueMatchSelector(String name, Selector<Context<?>> parent, long metrics, BiPredicate<T, Path<?, ?>> matcher, T value) {
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
}
