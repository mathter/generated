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

import java.util.Objects;
import java.util.function.Predicate;

abstract class Selector implements Predicate<Context<?>> {

    private String name;

    private int metrics;

    private Selector next;

    private Predicate<Context<?>> predicate;

    protected Selector(String name, int metrics, Selector next, Predicate<Context<?>> predicate) {
        this.name = Objects.requireNonNull(name);
        this.metrics = Objects.requireNonNull(metrics);
        this.next = next;
        this.predicate = Objects.requireNonNull(predicate);
    }

    public String name() {
        return this.name;
    }

    public int metrics() {
        return this.metrics;
    }

    public Selector next() {
        return this.next;
    }

    @Override
    public final boolean test(Context<?> context) {
        return this.predicate.test(context) && (this.next == null || this.next.test(context));
    }
}
