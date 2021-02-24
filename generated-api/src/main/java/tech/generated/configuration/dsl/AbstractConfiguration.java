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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.generated.Context;
import tech.generated.Filler;
import tech.generated.InstanceBuilder;
import tech.generated.util.NameGenerator;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class AbstractConfiguration implements Configuration {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractConfiguration.class);

    private static final int DEFAULT_GENERATION_DEEP = 100;

    private final String name = NameGenerator.nextName();

    private final Collection<Selectable> selectables = new HashSet<>();

    private final Dsl dsl;

    protected AbstractConfiguration() {
        this(DslFactory.dsl());
    }

    protected AbstractConfiguration(Dsl dsl) {
        this.dsl = dsl;

        this.add(
                this
                        .custom((c) -> c.stream().count() > maxGenerationDeep())
                        .metrics((c) -> Integer.MAX_VALUE)
                        .nonstrict((c, o) -> o, Object.class)
        );
    }

    @Override
    public Configuration add(Selectable selectable) {
        this.a(selectable);

        return this;
    }

    @Override
    public Collection<Selectable> selectables() {
        return Collections.unmodifiableCollection(this.selectables);
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public <T> Selectable nonstrict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.a(
                this.dsl.nonstrict(
                        Objects.requireNonNull(function),
                        Objects.requireNonNull(clazz)
                )
        );
    }

    @Override
    public <T> Selector nonstrict(Class<T> clazz) {
        return this.dsl.nonstrict(clazz);
    }

    @Override
    public <T> Selectable nonstrict(Filler<? extends T> function, Class<T> clazz) {
        return this.a(
                this.dsl.nonstrict(
                        Objects.requireNonNull(function),
                        Objects.requireNonNull(clazz)
                )
        );
    }

    @Override
    public Selector path(String path) {
        return this.dsl.path(Objects.requireNonNull(path));
    }

    @Override
    public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.a(
                this.dsl.strict(
                        Objects.requireNonNull(function),
                        Objects.requireNonNull(clazz)
                )
        );
    }

    @Override
    public <T> Selectable strict(Filler<T> function, Class<T> clazz) {
        return this.a(
                this.dsl.strict(
                        Objects.requireNonNull(function),
                        Objects.requireNonNull(clazz)
                )
        );
    }


    @Override
    public <T> Selector strict(Class<T> clazz) {
        return this.dsl.strict(clazz);
    }

    @Override
    public Selector custom(Predicate<Context<?>> predicate) {
        return this.dsl.custom(Objects.requireNonNull(predicate));
    }

    @Override
    public int maxGenerationDeep() {
        return DEFAULT_GENERATION_DEEP;
    }

    private Selectable a(Selectable selectable) {
        Objects.requireNonNull(selectable);

        this.selectables.add(selectable);
        LOG.debug("{} named {} were added to the configuration {}.", selectable, selectable.name(), this.name());

        return selectable;
    }

    public final Selector of(Selector selector) {
        return selector instanceof Wrapper ? selector : new Wrapper(selector);
    }

    private class Wrapper implements Selector {
        private final Selector selector;

        private Wrapper(Selector selector) {
            this.selector = selector;
        }

        @Override
        public <T> Selectable nonstrict(InstanceBuilder<T> function, Class<T> clazz) {
            return a(this.selector.nonstrict(function, clazz));
        }

        @Override
        public <T> Selectable nonstrict(Filler<? extends T> function, Class<T> clazz) {
            return a(this.selector.nonstrict(function, clazz));
        }

        @Override
        public <T> Selector nonstrict(Class<T> clazz) {
            return of(this.selector.nonstrict(clazz));
        }

        @Override
        public Selector path(String path) {
            return of(this.selector.path(path));
        }

        @Override
        public String name() {
            return this.selector.name();
        }

        @Override
        public Selector next() {
            return of(this.selector.next());
        }

        @Override
        public Selector metrics(Function<Context<?>, Integer> metrics) {
            return of(this.selector.metrics(metrics));
        }

        @Override
        public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz) {
            return a(this.selector.strict(function, clazz));
        }

        @Override
        public <T> Selector strict(Class<T> clazz) {
            return of(this.selector.strict(clazz));
        }

        @Override
        public <T> Selectable strict(Filler<T> function, Class<T> clazz) {
            return a(this.selector.strict(function, clazz));
        }

        @Override
        public Selector custom(Predicate<Context<?>> predicate) {
            return of(this.selector.custom(predicate));
        }
    }
}
