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
package tech.generated.loly.context;

import tech.generated.Bindings;
import tech.generated.Context;
import tech.generated.Util;
import tech.generated.loly.reflect.FieldAccessor;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Objects;

public class ValFieldContext<T> extends ValueContext<T> implements FieldAccessor<T> {

    private final Field field;

    public ValFieldContext(Bindings bindings, Field field) {
        super(bindings);
        this.field = Objects.requireNonNull(field);
    }

    public ValFieldContext(ValueContext<?> parent, Field field) {
        super(parent);
        this.field = Objects.requireNonNull(field);
    }

    @Override
    public Class<T> clazz() {
        return (Class<T>) this.field.getType();
    }

    @Override
    public T node() {
        return this.get();
    }

    @Override
    public String name() {
        return this.field.getName();
    }

    @Override
    public Collection<? extends Context<?>> childs() {
        return null;
    }

    @Override
    public T get() {
        return Util.getFieldValue(this.field, this.parent().node());
    }

    @Override
    public void set(T value) {
        Util.setFieldValue(this.field, this.parent().node(), value);
    }
}
