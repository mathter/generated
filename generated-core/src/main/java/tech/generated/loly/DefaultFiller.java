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
package tech.generated.loly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.generated.Context;
import tech.generated.Filler;
import tech.generated.InstanceBuilder;
import tech.generated.loly.context.RefFieldContext;
import tech.generated.loly.context.Stage;
import tech.generated.loly.context.ValFieldContext;
import tech.generated.loly.context.ValueContext;
import tech.generated.loly.reflect.Accessor;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

class DefaultFiller<T> implements Filler<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultFiller.class);

    private Collection<String> skippedFieldNames = new HashSet<>();

    private final ValueContext<T> context;

    private final LolyObjectFactory objectFactory;

    public DefaultFiller(LolyObjectFactory objectFactory, ValueContext<T> context) {
        this.context = context;
        this.objectFactory = objectFactory;
    }

    @Override
    public T apply(Context<T> context, T object) {
        this.classes(this.context.clazz())
                .flatMap(this::accessors)
                .forEach(this::fill);

        return object;
    }

    private <T> void fill(Accessor<T> accessor) {
        final ValueContext<T> context = (ValueContext<T>) accessor;

        if (context.getStage() != Stage.COMPLETE) {
            final InstanceBuilder<T> instanceBuilder = this.objectFactory.instanceBuilder(context);
            final Filler<T> filler = this.objectFactory.filler(context);
            final T object = instanceBuilder.apply(context);

            accessor.set(object);
            context.setStage(Stage.INITIALIZATION);
            accessor.set(filler.apply(context, object));
            context.setStage(Stage.COMPLETE);
        }
    }

    private Stream<Accessor<?>> accessors(Class<?> clazz) {
        return this.fieldAccessors(clazz);
    }

    private Stream<Accessor<?>> fieldAccessors(Class<?> clazz) {
        return java.util.stream.Stream
                .of(clazz.getDeclaredFields())
                .filter(f -> !DefaultFiller.this.skippedFieldNames.contains(f.getName()))
                .map(f -> f.getType().isPrimitive()
                        ? new ValFieldContext(this.context, f)
                        : new RefFieldContext(this.context, f)
                );
    }

    private Stream<Class<?>> classes(Class<?> clazz) {
        return tech.generated.util.Stream.of(clazz, Class::getSuperclass);
    }
}
