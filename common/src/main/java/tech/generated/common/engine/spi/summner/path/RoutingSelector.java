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
import tech.generated.common.path.Selector;

public class RoutingSelector extends AbstractSelector {

    private final Selector<Context<?>> horizontal;

    public RoutingSelector(String name, Selector<Context<?>> next, long metrics, Selector<Context<?>> horizontal) {
        super(name, next, metrics);
        this.horizontal = horizontal;
    }

    @Override
    public boolean test(Context<?> context) {
        return (this.horizontal != null && this.horizontal.test(context)) && super.test(context);
    }
}
