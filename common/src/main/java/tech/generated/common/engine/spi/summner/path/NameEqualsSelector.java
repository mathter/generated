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
import tech.generated.common.Constants;
import tech.generated.common.path.Selector;

import java.util.Objects;

public class NameEqualsSelector extends ChainValueMatchSelector<String> {

    public NameEqualsSelector(String name, Selector<Context<?>> parent, String value) {
        this(name, parent, Constants.METRICS_UNIT, value);
    }

    public NameEqualsSelector(String name, Selector<Context<?>> parent, long metrics, String value) {
        super(name, parent, metrics, (name1, path) -> Objects.equals(name1, path.name()), value);
    }
}
