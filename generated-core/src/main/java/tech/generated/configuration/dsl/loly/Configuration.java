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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.generated.Context;
import tech.generated.Filler;
import tech.generated.InstanceBuilder;
import tech.generated.configuration.dsl.Selectable;
import tech.generated.configuration.dsl.Selector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

class Configuration implements tech.generated.configuration.dsl.Configuration {

    private static final Logger LOG = LoggerFactory.getLogger(Configuration.class);

    private final Dsl dsl;

    private final String name = NameGenerator.nextName();

    private final Collection<Selectable> selectables = new ArrayList<>();

    protected Configuration(Dsl dsl) {

        this.dsl = dsl;
    }

    @Override
    public final tech.generated.configuration.dsl.Configuration add(Selectable selectable) {

        this.selectables.add(selectable);
        LOG.debug("{} named {} were added to the configuration {}.", selectable, selectable.name(), this.name());

        return this;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public <T> Selectable nonstrict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.dsl.nonstrict(function, clazz);
    }

    @Override
    public <T> Selectable nonstrict(Filler<? extends T> function, Class<T> clazz) {
        return this.dsl.nonstrict(function, clazz);
    }

    @Override
    public Path path(String path) {
        return this.dsl.path(path);
    }

    @Override
    public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.dsl.strict(function, clazz);
    }

    @Override
    public <T> Selectable strict(Filler<T> function, Class<T> clazz) {
        return this.dsl.strict(function, clazz);
    }

    @Override
    public Selector custom(Predicate<Context<?>> predicate) {
        return this.dsl.custom(predicate);
    }
}
