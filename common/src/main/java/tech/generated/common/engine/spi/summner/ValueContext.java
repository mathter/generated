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

import tech.generated.common.Bindings;
import tech.generated.common.Context;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.engine.spi.reflect.Accessor;
import tech.generated.common.path.Path;

public abstract class ValueContext<T> implements Context<T>, Accessor<T> {

    private final Context<?> parent;

    private final Bindings bindings;

    private final GeneratedEngine generatedEngine;

    private boolean isActiveted;

    protected ValueContext(Bindings parentBindings, GeneratedEngine generatedEngine) {
        this.parent = null;
        this.bindings = parentBindings != null ? Bindings.bindings(parentBindings) : Bindings.bindings();
        this.generatedEngine = generatedEngine;
        this.isActiveted = false;
    }

    protected ValueContext(Context<?> parent) {
        this.parent = parent;
        this.bindings = parent != null ? Bindings.bindings(parent.getBindings()) : Bindings.bindings();
        this.generatedEngine = parent.getGeneratedEngine();
        this.isActiveted = false;
    }

    public boolean isActiveted() {
        return isActiveted;
    }

    public void setActiveted(boolean activeted) {
        isActiveted = activeted;
    }

    @Override
    public Bindings getBindings() {
        return this.bindings;
    }

    @Override
    public tech.generated.common.GeneratedEngine getGeneratedEngine() {
        return this.generatedEngine;
    }

    @Override
    public Path<?, ? extends Context<T>> parent() {
        return (Path<?, ? extends Context<T>>) this.parent;
    }
}
