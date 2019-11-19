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
package tech.generated.common.engine.spi.summner;

import tech.generated.common.Bindings;
import tech.generated.common.Context;

public class ObjectContext<T> extends ComplexContext<T> {
    private T object;

    private final Class<T> clazz;

    public ObjectContext(Class<T> clazz, Bindings bindings, GeneratedEngine generatedEngine) {
        super(bindings, generatedEngine);
        this.clazz = clazz;
    }

    @Override
    public T get() {
        return this.object;
    }

    @Override
    public void set(T value) {
        this.object = value;
    }

    @Override
    public Class<T> clazz() {
        return this.object != null ? (Class<T>) this.object.getClass() : this.clazz;
    }

    @Override
    public T node() {
        return this.object;
    }

    @Override
    public String name() {
        return "<ROOT>";
    }
}
