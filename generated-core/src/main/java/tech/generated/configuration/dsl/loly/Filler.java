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
package tech.generated.configuration.dsl.loly;

import tech.generated.configuration.dsl.Selector;
import tech.generated.configuration.dsl.SimpleSelectableException;

class Filler<T> extends Selectable<T> {

    final tech.generated.Filler<T> function;

    Filler(tech.generated.Filler<T> function, ClassSelector<T> selector) {
        super(selector);
        this.function = function;
    }

    @Override
    public Selector selector() {
        return null;
    }

    @Override
    public tech.generated.Filler<?> function() {
        return this.function;
    }

    @Override
    public void simple() {
        throw new SimpleSelectableException(this);
    }

    @Override
    public boolean isSimple() {
        throw new SimpleSelectableException(this);
    }
}
