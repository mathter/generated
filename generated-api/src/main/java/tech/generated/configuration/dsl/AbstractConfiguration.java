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
import java.util.function.Consumer;
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
                        .metrics((c) -> Long.MAX_VALUE)
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
        return wrap(this.dsl.nonstrict(clazz));
    }

    @Override
    public <T> Selectable nonstrict(Filler<? extends T> function, Class<T> clazz) {
        return this.a(
                this.wrap(
                        this.dsl.nonstrict(
                                Objects.requireNonNull(function),
                                Objects.requireNonNull(clazz)
                        )
                )
        );
    }

    @Override
    public Selector path(String path) {
        return wrap(this.dsl.path(Objects.requireNonNull(path)));
    }

    @Override
    public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz) {
        return this.a(
                this.wrap(
                        this.dsl.strict(
                                Objects.requireNonNull(function),
                                Objects.requireNonNull(clazz)
                        )
                )
        );
    }

    @Override
    public <T> Selectable strict(Filler<T> function, Class<T> clazz) {
        return this.a(
                this.wrap(
                        this.dsl.strict(
                                Objects.requireNonNull(function),
                                Objects.requireNonNull(clazz)
                        )
                )
        );
    }


    @Override
    public <T> Selector strict(Class<T> clazz) {
        return wrap(this.dsl.strict(clazz));
    }

    @Override
    public Selector custom(Predicate<Context<?>> predicate) {
        return wrap(this.dsl.custom(Objects.requireNonNull(predicate)));
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

    private Selectable wrap(Selectable selectable) {
        final Selectable result;

        result = new SelectableWrapper(selectable);

        return result;
    }

    private Selector wrap(Selector selector) {
        final Selector result;

        if (selector instanceof SelectorWrapper) {
            result = selector;
        } else {
            if (selector instanceof Path) {
                result = new PathSelectorWrapper(selector);
            } else if (selector instanceof Custom) {
                result = new CustomSelectorWrapper(selector);
            } else {
                result = new SelectorWrapper(selector);
            }
        }

        return result;
    }

    private class SelectorWrapper implements Selector {
        protected final Selector selector;

        private SelectorWrapper(Selector selector) {
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
            return wrap(this.selector.nonstrict(clazz));
        }

        @Override
        public Selector path(String path) {
            return wrap(this.selector.path(path));
        }

        @Override
        public String name() {
            return this.selector.name();
        }

        @Override
        public Selector next() {
            return wrap(this.selector.next());
        }

        @Override
        public Selector metrics(Function<Context<?>, Long> metrics) {
            return wrap(this.selector.metrics(metrics));
        }

        @Override
        public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz) {
            return a(this.selector.strict(function, clazz));
        }

        @Override
        public <T> Selector strict(Class<T> clazz) {
            return wrap(this.selector.strict(clazz));
        }

        @Override
        public <T> Selectable strict(Filler<T> function, Class<T> clazz) {
            return a(this.selector.strict(function, clazz));
        }

        @Override
        public Selector custom(Predicate<Context<?>> predicate) {
            return wrap(this.selector.custom(predicate));
        }

        @Override
        public void use(Consumer<Selector> consumer) {
            Objects.requireNonNull(consumer).accept(this);
        }

        @Override
        public <T> Selectable filler(Filler<T> function) {
            return a(this.selector.filler(function));
        }

        @Override
        public <T> Selectable instanceBuilder(InstanceBuilder<T> function) {
            return null;
        }
    }

    private class PathSelectorWrapper extends SelectorWrapper implements Path {
        public PathSelectorWrapper(Selector selector) {
            super(selector);
        }

        @Override
        public String path() {
            return ((Path) this.selector).path();
        }
    }

    private class CustomSelectorWrapper extends SelectorWrapper implements Custom {
        public CustomSelectorWrapper(Selector selector) {
            super(selector);
        }

        @Override
        public Predicate<Context<?>> predicate() {
            return ((Custom) this.selector).predicate();
        }
    }

    private class SelectableWrapper implements Selectable {
        private final Selectable selectable;

        public SelectableWrapper(Selectable selectable) {
            this.selectable = Objects.requireNonNull(selectable);
        }

        @Override
        public Selector selector() {
            return wrap(this.selectable.selector());
        }

        @Override
        public String name() {
            return this.selectable.name();
        }

        @Override
        public Object function() {
            return this.selectable.function();
        }

        @Override
        public void simple() {
            this.selectable.simple();
        }

        @Override
        public boolean isSimple() throws SimpleSelectableException {
            return this.selectable.isSimple();
        }
    }
}
