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

import tech.generated.common.Context;
import tech.generated.common.FillerFactory;
import tech.generated.common.Init;
import tech.generated.common.InstanceBuilderFactory;
import tech.generated.common.NewInstanceException;

import java.util.function.Function;
import java.util.function.Supplier;

public class ObjectFactory implements tech.generated.common.ObjectFactory {

    private final GeneratedEngine engine;

    public ObjectFactory(GeneratedEngine engine) {
        this.engine = engine;
    }

    @Override
    public <T> ObjectContext<T> buildContext(Init<T> init) throws NewInstanceException {
        final InstanceBuilderFactory instanceBuilderFactory = this.engine.instanceBuilderFactory();
        final ObjectContext<T> context = new ObjectContext<T>(init.clazz(), init.getBindings(), this.engine);
        final Supplier<T> instanceBuilder = instanceBuilderFactory.builder(context);
        final FillerFactory fillerFactory = this.engine.fillerFactory();
        final T object = instanceBuilder.get();
        final Function<T, T> filler = fillerFactory.filler(context);

        context.set(object);
        filler.apply(object);

        return context;
    }
}
