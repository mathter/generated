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
import tech.generated.util.Stream;

import java.util.function.Function;

public class SkipSelector extends Selector {

    public SkipSelector(String name, Function<Context<?>, Integer> metrics, Selector next, int count) {
        super(
                name,
                metrics,
                next,
                (context) -> Stream
                        .of(context, new Function<Context<?>, Context<?>>() {
                            @Override
                            public Context<?> apply(Context<?> context) {
                                return (Context<?>) context.parent();
                            }
                        })
                        .skip(count)
                        .findFirst()
                        .map(e -> next != null ? next.test(e) : true)
                        .orElse(false)
                );
    }
}
