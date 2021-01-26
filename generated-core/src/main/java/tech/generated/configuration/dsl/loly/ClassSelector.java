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
package tech.generated.configuration.dsl.loly;

import tech.generated.Context;

import java.util.function.Predicate;

abstract class ClassSelector<T> extends Selector implements tech.generated.configuration.dsl.Selector {

    private final Class<T> clazz;

    protected ClassSelector(Dsl dsl, String name, Selector selector, Class<T> clazz) {
        super(dsl, name, selector);
        this.clazz = clazz;
    }

    @Override
    public tech.generated.configuration.dsl.Selector custom(Predicate<Context<?>> predicate) {
        return null;
    }

    static class Strict<T> extends ClassSelector {
        Strict(Dsl dsl, String name, Selector selector, Class<T> clazz) {
            super(dsl, name, selector, clazz);
        }
    }

    static class NonStrict<T> extends ClassSelector {
        NonStrict(Dsl dsl, String name, Selector selector, Class<T> clazz) {
            super(dsl, name, selector, clazz);
        }
    }
}
