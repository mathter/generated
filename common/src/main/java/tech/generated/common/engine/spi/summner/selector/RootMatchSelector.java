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
import tech.generated.common.engine.spi.summner.ObjectContext;
import tech.generated.common.path.Selector;

public class RootMatchSelector extends AbstractSelector {

    public RootMatchSelector(String name, Selector<Context<?>> parent) {
        this(name, parent, 1);
    }

    public RootMatchSelector(String name, Selector<Context<?>> parent, long metrics) {
        super(name, parent, metrics);
    }

    @Override
    public boolean test(Context<?> path) {
        return path.getClass().equals(ObjectContext.class) && super.test(path);
    }
}
