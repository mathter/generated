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

public class SkipNameSelector extends AbstractSelector {

    private final int count;

    public SkipNameSelector(String name, Selector<Context<?>> parent, int count) {
        this(name, parent, count, count);
    }

    public SkipNameSelector(String name, Selector<Context<?>> parent, long metrics, int count) {
        super(name, parent, metrics);

        if (count < 0) {
            throw new IllegalArgumentException("count can't be less then zero!");
        }

        this.count = count;
    }

    @Override
    public boolean test(Context<?> path) {
        Path<?, ?> p = path;

        for (int i = 0; i < count && p != null; i++, p = p.parent()) ;

        return p != null && super.test((Context<?>) p);
    }
}
