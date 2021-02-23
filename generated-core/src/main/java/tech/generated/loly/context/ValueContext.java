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
package tech.generated.loly.context;

import tech.generated.Bindings;
import tech.generated.Context;
import tech.generated.loly.reflect.Accessor;

abstract class ValueContext<T> implements Context<T>, Accessor<T> {

    private final ValueContext<?> parent;

    private final Bindings bindings;

    private Stage stage = Stage.NEW;

    public ValueContext(Bindings bindings) {
        this.parent = null;
        this.bindings = bindings;
    }

    public ValueContext(ValueContext<?> parent) {
        this.parent = parent;
        this.bindings = parent.bindings();
    }

    @Override
    public Bindings bindings() {
        return this.bindings;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public ValueContext<?> parent() {
        return this.parent;
    }
}


