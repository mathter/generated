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

import tech.generated.Context;
import tech.generated.Filler;
import tech.generated.InstanceBuilder;
import tech.generated.Spec;
import tech.generated.Util;
import tech.generated.loly.context.ComplexContext;
import tech.generated.loly.context.ObjectContext;
import tech.generated.loly.context.ValueContext;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

final class LolyObjectFactory implements tech.generated.ObjectFactory {
    private final BConfiguration configuration;

    public LolyObjectFactory(BConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> tech.generated.ObjectContext<T> build(Spec<T> initContext) {
        final ObjectContext context = new ObjectContext(initContext.bindings(), initContext.clazz());
        final InstanceBuilder<T> instanceBuilder = this.instanceBuilder(context);
        final Filler<T> filler = Util.isSimple(context.clazz()) ? new UnitFiller<>() : new DefaultFiller<>(this, context);
        final T object = instanceBuilder.apply(context);
        context.set(object);
        context.set(filler.apply(context, object));

        return context;
    }

    public <T> InstanceBuilder<T> instanceBuilder(Context<T> context) {
        Collection<Selector> candidates = this
                .configuration
                .getInstanceBuilderSelectors()
                .filter(s -> s.test(context))
                .collect(Collectors.toList());

        if (candidates.isEmpty() && Util.isBoxing(context.clazz())) {
            candidates = this
                    .configuration
                    .getInstanceBuilderSelectors()
                    .filter(s -> s instanceof AsBoxed && ((AsBoxed<Selector>) s).asBoxed().test(context))
                    .collect(Collectors.toList());
        }

        return candidates
                .stream()
                .max(Comparator.comparing(Selector::metrics))
                .map(s -> this.configuration.getInstanceBuilder(s))
                .orElse(new DefaultInstanceBuilder(context.clazz()));
    }

    public <T> Filler<T> filler(Context<T> context) {
        Collection<Selector> candidates = this
                .configuration
                .getFillerSelectors()
                .filter(s -> s.test(context))
                .collect(Collectors.toList());

        if (candidates.isEmpty() && Util.isBoxing(context.clazz())) {
            candidates = this
                    .configuration
                    .getFillerSelectors()
                    .filter(s -> s.test(context))
                    .collect(Collectors.toList());
        }

        return (Filler<T>) candidates
                .stream()
                .max(Comparator.comparing(Selector::metrics))
                .map(s -> this.configuration.getFiller(s))
                .orElse(
                        Util.isSimple(context.clazz())
                                ? new UnitFiller<>() :
                                new DefaultFiller(this, (ValueContext) context)
                );
    }
}
