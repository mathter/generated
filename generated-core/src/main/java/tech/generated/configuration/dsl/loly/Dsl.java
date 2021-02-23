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
import tech.generated.configuration.dsl.Configuration;
import tech.generated.configuration.dsl.Selectable;
import tech.generated.util.NameGenerator;

import java.util.Objects;
import java.util.function.Predicate;

class Dsl implements tech.generated.configuration.dsl.Dsl {

    private static Logger LOG = LoggerFactory.getLogger(Dsl.class);

    @Override
    public Path path(String path) {
        return this.path(path, null);
    }

    public Path path(String path, Selector next) {
        Objects.requireNonNull(path);

        final String name = NameGenerator.nextName();
        LOG.debug("Constract path selector '{}' for '{}'", name, path);
        return new Path(this, name, next, path);
    }

    @Override
    public Selector custom(Predicate<Context<?>> predicate) {
        return this.custom(predicate, null);
    }

    public Selector custom(Predicate<Context<?>> predicate, Selector next) {
        Objects.requireNonNull(predicate);

        final String name = NameGenerator.nextName();
        LOG.debug("Constract custom selector '{}' for '{}'", name, predicate);
        return new CustomSelector(this, name, next, predicate);
    }

    @Override
    public <T> Selectable nonstrict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.nonstrict(function, clazz, null);
    }

    public <T> Selectable nonstrict(InstanceBuilder<T> function, Class<T> clazz, Selector next) {
        Objects.requireNonNull(function);
        Objects.requireNonNull(clazz);

        final String name = NameGenerator.nextName();
        LOG.debug("Constract nonstrict instanceBuilder '{}' for '{}' with '{}'", name, clazz, function);
        return new tech.generated.configuration.dsl.loly.InstanceBuilder(function, new ClassSelector.NonStrict(this, name, next, clazz));
    }

    @Override
    public <T> Selectable nonstrict(Filler<? extends T> function, Class<T> clazz) {
        return this.nonstrict(function, clazz, null);
    }

    public <T> Selectable nonstrict(Filler<? extends T> function, Class<T> clazz, Selector next) {
        Objects.requireNonNull(function);
        Objects.requireNonNull(clazz);

        final String name = NameGenerator.nextName();
        LOG.debug("Constract nonstrict filler '{}' for '{}' with '{}'", name, clazz, function);
        return new tech.generated.configuration.dsl.loly.Filler(function, new ClassSelector.NonStrict(this, name, next, clazz));
    }

    @Override
    public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.strict(function, clazz, null);
    }

    public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz, Selector next) {
        Objects.requireNonNull(function);
        Objects.requireNonNull(clazz);

        final String name = NameGenerator.nextName();
        LOG.debug("Constract strict instanceBuilder '{}' for '{}' with '{}'", name, clazz, function);
        return new tech.generated.configuration.dsl.loly.InstanceBuilder(function, new ClassSelector.Strict(this, name, null, clazz));
    }

    @Override
    public <T> Selectable strict(Filler<T> function, Class<T> clazz) {
        return this.strict(function, clazz, null);
    }

    public <T> Selectable strict(Filler<T> function, Class<T> clazz, Selector next) {
        Objects.requireNonNull(function);
        Objects.requireNonNull(clazz);

        final String name = NameGenerator.nextName();
        LOG.debug("Constract strict filler '{}' for '{}' with '{}'", name, clazz, function);
        return new tech.generated.configuration.dsl.loly.Filler(function, new ClassSelector.Strict(this, name, null, clazz));
    }
}
