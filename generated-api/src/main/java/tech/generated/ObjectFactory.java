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
package tech.generated;

import java.util.stream.Stream;

public interface ObjectFactory {

    public default <T> T build(Class<T> clazz) {
        return (T) this.build(InitContext.of(clazz)).get();
    }

    public <T> ObjectContext<T> build(Context<?> context);

    public static class InitContext<T> implements Context<T> {
        private final Class<T> clazz;

        private final Bindings bindings;

        public static <T> InitContext<T> of(Class<T> clazz) {
            return of(clazz, null);
        }

        public static <T> InitContext<T> of(Class<T> clazz, Bindings bindings) {
            return new InitContext<>(clazz, bindings);
        }

        private InitContext(Class<T> clazz, Bindings bindings) {
            this.clazz = clazz;
            this.bindings = bindings != null ? bindings : Bindings.bindings();
        }

        @Override
        public Bindings bindings() {
            return this.bindings;
        }

        @Override
        public Class<T> clazz() {
            return this.clazz;
        }

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
            return null;
        }

        @Override
        public Stream<Path<?, ?>> child() {
            return null;
        }
    }
}
