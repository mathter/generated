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
package tech.generated.common.engine.spi.summner.dsl;

import tech.generated.common.Context;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.dsl.Configuration;
import tech.generated.common.dsl.Filler;
import tech.generated.common.dsl.InstanceBuilder;
import tech.generated.common.dsl.NonStrict;
import tech.generated.common.dsl.Path;
import tech.generated.common.dsl.Strict;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Dsl implements tech.generated.common.dsl.Dsl {
    private final GeneratedEngine generatedEngine;

    public Dsl(GeneratedEngine generatedEngine) {
        this.generatedEngine = generatedEngine;
    }


    @Override
    public <T> InstanceBuilder instanceBuilder(Function<Context<?>, T> function) {
        return new tech.generated.common.engine.spi.summner.dsl.InstanceBuilder(function);
    }

    @Override
    public <T> Filler filler(BiFunction<Context<?>, T, T> function) {
        return new tech.generated.common.engine.spi.summner.dsl.Filler(function);
    }

    @Override
    public <T> NonStrict<T> nonstrictable(Class<T> clazz) {
        return new tech.generated.common.engine.spi.summner.dsl.NonStrict(clazz, null);
    }

    @Override
    public Path path(String path) {
        return new tech.generated.common.engine.spi.summner.dsl.Path(path, null);
    }

    @Override
    public <T> Strict<T> strict(Class<T> clazz) {
        return new tech.generated.common.engine.spi.summner.dsl.Strict(clazz, null);
    }

    @Override
    public Configuration configuration() {
        return new tech.generated.common.engine.spi.summner.dsl.Configuration(this);
    }
}
