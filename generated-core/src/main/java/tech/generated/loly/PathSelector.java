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

import tech.generated.Context;
import tech.generated.configuration.dsl.Path;

import java.util.function.Predicate;

public class PathSelector extends Selector {

    public PathSelector(String name, int metrics, Selector next, Path path) {
        super(name, metrics, next, buildPredicate(path));
    }

    private static Predicate<Context<?>> buildPredicate(Path path) {
        //TODO
        return null;
    }
}
