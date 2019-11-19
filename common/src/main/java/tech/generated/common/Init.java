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
package tech.generated.common;

import tech.generated.common.path.Path;

import java.util.stream.Stream;

public class Init<T> implements Context<T> {

    private final Class<T> clazz;

    private final Bindings bindings;

    @Override
    public T node() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Path<?, ? extends Context<T>> parent() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<Path<?, ?>> child() {
        throw new UnsupportedOperationException();
    }

    public static <T> Builder<T> builder(Class<T> clazz) {
        return new Builder<>(clazz);
    }

    private Init(Class<T> clazz) {
        this.clazz = clazz;
        this.bindings = null;
    }

    private Init(Class<T> clazz, Bindings bindings) {
        this.clazz = clazz;
        this.bindings = bindings;
    }

    public Bindings getBindings() {
        return this.bindings;
    }

    @Override
    public GeneratedEngine getGeneratedEngine() {
        throw new UnsupportedOperationException();
    }

    public Class<T> clazz() {
        return this.clazz;
    }

    public static class Builder<T> {
        private Class<T> clazz;

        private Bindings bindings;

        private Builder(Class<T> clazz) {
            this.clazz = clazz;
        }

        public Builder<T> bindings(Bindings bindings) {
            this.bindings = bindings;

            return this;
        }

        public Init<T> build() {
            return new Init<T>(this.clazz, this.bindings);
        }
    }
}
