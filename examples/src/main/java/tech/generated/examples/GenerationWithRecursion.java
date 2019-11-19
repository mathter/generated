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
package tech.generated.examples;

import tech.generated.common.Context;
import tech.generated.common.DefaultFiller;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.GeneratedEngineFactory;
import tech.generated.common.ObjectFactory;
import tech.generated.common.annotation.DefaultConfiguration;
import tech.generated.common.annotation.Filler;

public class GenerationWithRecursion {
    public static void main(String[] args) {
        GeneratedEngine engine = GeneratedEngineFactory.newInstance(
                null,
                new DefaultConfiguration() {
                    final int DEEP = 10;

                    @Filler
                    public WithRecursion filler(WithRecursion object, Context<WithRecursion> context) {
                        if (context.stream().count() < DEEP) {
                            new DefaultFiller<>(context)
                                    .apply(object);
                        }

                        return object;
                    }
                });

        ObjectFactory objectFactory = engine.objectFactory();

        WithRecursion object = objectFactory.build(WithRecursion.class);

        System.out.println(object);
    }
}

class WithRecursion {
    private WithRecursion parent;

    @Override
    public String toString() {
        return new StringBuilder("WithRecursion[parent=").append(this.parent).append(']').toString();
    }
}