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

import java.util.function.BiFunction;

class Filler<T> extends AbstractSelectable<tech.generated.common.dsl.Filler> implements tech.generated.common.dsl.Filler {
    private final BiFunction<Context<?>, T, T> function;

    Filler(BiFunction<Context<?>, T, T> function) {
        this.function = function;
    }
}
