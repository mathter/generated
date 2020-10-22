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

import tech.generated.common.dsl.NonStrict;
import tech.generated.common.dsl.Path;
import tech.generated.common.dsl.Selector;
import tech.generated.common.dsl.Strict;

import java.util.stream.Stream;

abstract class AbstractSelector implements Selector {
    protected final Selector prev;

    protected Selector next;

    protected AbstractSelector(Selector prev) {
        this.prev = prev;
    }

    @Override
    public <T> NonStrict<T> nonstrictable(Class<T> clazz) {
        this.checkClassSelector();
        this.next = new tech.generated.common.engine.spi.summner.dsl.NonStrict(clazz, this);
        return (NonStrict<T>) this.next;
    }

    @Override
    public Path path(String path) {
        this.next = new tech.generated.common.engine.spi.summner.dsl.Path(path, this);
        return (Path) this.next;
    }

    @Override
    public <T> Strict<T> strict(Class<T> clazz) {
        this.checkClassSelector();
        this.next = new tech.generated.common.engine.spi.summner.dsl.Strict(clazz, this);
        return (Strict<T>) this.next;
    }

    @Override
    public Stream<Selector> up() {
        final Stream<Selector> result;

        if (this.prev != null) {
            result = Stream.concat(Stream.of(this), this.prev.up());
        } else {
            result = Stream.of(this);
        }

        return result;
    }

    protected void checkClassSelector() {
        this
                .up()
                .filter(e -> e instanceof Strict || e instanceof NonStrict).findAny()
                .ifPresent(e -> {
                            throw new IllegalStateException("Can't create class selector as chain of the another class selector!");
                        }
                );
    }
}
