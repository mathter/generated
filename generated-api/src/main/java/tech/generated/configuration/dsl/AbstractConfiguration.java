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
package tech.generated.configuration.dsl;

import tech.generated.Context;
import tech.generated.Filler;
import tech.generated.InstanceBuilder;

import java.util.Collection;
import java.util.function.Predicate;

public class AbstractConfiguration implements Configuration {

    private final Dsl dsl;

    private final Configuration configuration;

    protected AbstractConfiguration(Dsl dsl) {
        this.dsl = dsl;
        this.configuration = this.dsl.configuration();
    }

    @Override
    public Configuration add(Selectable selectable) {
        return this.configuration.add(selectable);
    }

    @Override
    public Collection<Selectable> selectables() {
        return this.configuration.selectables();
    }

    @Override
    public String name() {
        return this.configuration.name();
    }

    @Override
    public <T> Selectable nonstrict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.configuration.nonstrict(function, clazz);
    }

    @Override
    public <T> Selectable nonstrict(Filler<? extends T> function, Class<T> clazz) {
        return this.configuration.nonstrict(function, clazz);
    }

    @Override
    public Selector path(String path) {
        return this.configuration.path(path);
    }

    @Override
    public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.configuration.strict(function, clazz);
    }

    @Override
    public <T> Selectable strict(Filler<T> function, Class<T> clazz) {
        return this.configuration.strict(function, clazz);
    }

    @Override
    public Selector custom(Predicate<Context<?>> predicate) {
        return this.configuration.custom(predicate);
    }
}
