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
import tech.generated.Filler;
import tech.generated.InstanceBuilder;
import tech.generated.configuration.dsl.Selectable;

import java.util.function.Predicate;

abstract class Selector implements tech.generated.configuration.dsl.Selector {

    private final Dsl dsl;

    private final String name;

    private Integer metrics;

    private final Selector next;

    public Selector(Dsl dsl, String name, Selector next) {
        this(dsl, name, null, next);
    }

    public Selector(Dsl dsl, String name, Integer metrics, Selector next) {
        this.dsl = dsl;
        this.name = name;
        this.metrics = metrics;
        this.next = next;
    }

    public String name() {
        return this.name;
    }

    @Override
    public tech.generated.configuration.dsl.Selector next() {
        return this.next;
    }

    @Override
    public Integer metrics() {
        return this.metrics != null ? this.metrics : 1;
    }

    @Override
    public <T> Selectable nonstrict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.dsl.nonstrict(function, clazz, this);
    }

    @Override
    public <T> Selectable nonstrict(Filler<? extends T> function, Class<T> clazz) {
        return this.dsl.nonstrict(function, clazz, this);
    }

    @Override
    public Path path(String path) {
        return this.dsl.path(path, this);
    }

    @Override
    public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.dsl.strict(function, clazz, this);
    }

    @Override
    public <T> Selectable strict(Filler<T> function, Class<T> clazz) {
        return this.dsl.strict(function, clazz, this);
    }

    @Override
    public tech.generated.configuration.dsl.Selector custom(Predicate<Context<?>> predicate) {
        return this.dsl.custom(predicate, this);
    }
}
