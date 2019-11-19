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
package tech.generated.common;

import java.util.function.Supplier;

/**
 * Class of instance builder factory.
 *
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface InstanceBuilderFactory {

    /**
     * Method create new {@linkplain Supplier} for object of specified class and using top {@linkplain Context}
     *
     * @param context context of top object, can be null
     * @param <T>     type of object which will be created.
     * @return new instance object of type <code>T</code>
     */
    public <T> Supplier<T> builder(Context<T> context);
}
