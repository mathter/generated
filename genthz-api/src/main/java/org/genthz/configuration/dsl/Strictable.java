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
package org.genthz.configuration.dsl;


import org.genthz.Filler;
import org.genthz.InstanceBuilder;

public interface Strictable {

    default public <T> Selectable strict(InstanceBuilder<T> function) {
        return strict(function, null);
    }

    public <T> Selectable strict(InstanceBuilder<T> function, Class<T> clazz);

    public <T> Selector strict(Class<T> clazz);

    default public <T> Selectable strict(Filler<T> function) {
        return strict(function, null);
    }

    public <T> Selectable strict(Filler<T> function, Class<T> clazz);
}
