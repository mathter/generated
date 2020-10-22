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
package tech.generated.common.engine.spi.summner.selector;

import tech.generated.common.Context;
import tech.generated.common.path.Selector;
import tech.generated.common.engine.spi.Util;

abstract class AbstractSelector implements Selector<Context<?>>, Cloneable {

    private final String name;

    protected final Selector<Context<?>> next;

    private final long metrics;

    public AbstractSelector(String name, Selector<Context<?>> next, long metrics) {
        if (name == null) {
            throw new IllegalArgumentException("name can't be null!");
        }
        this.name = name;
        this.next = next;
        this.metrics = metrics;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Selector<Context<?>> next() {
        return this.next;
    }

    @Override
    public long metrics() {
        return this.next != null ? this.next.metrics() + this.metrics : this.metrics;
    }

    @Override
    public boolean test(Context<?> path) {
        return this.next == null || this.next.test(path);
    }

    @Override
    public AbstractSelector clone() throws CloneNotSupportedException {
        final AbstractSelector clone = (AbstractSelector) super.clone();

        try {
            Util.setFieldValue(AbstractSelector.class.getField("next"), clone, this.next.clone());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        return clone;
    }
}
