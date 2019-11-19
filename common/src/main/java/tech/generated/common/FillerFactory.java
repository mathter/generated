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

import java.util.function.Function;

/**
 * Filler factory.
 *
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FillerFactory {

    /**
     * Method return a filler instance for filling object of the clazz
     *
     * @param context context used for building filler. Can't be null.
     * @param <T>     type of the object.
     * @return object filler.
     */
    public <T> Function<T, T> filler(Context<T> context);

    /**
     * Method return a default filler used for complex object.
     *
     * @param context context used for building filler. Can't be null.
     * @param <T>     type of the object.
     * @return default object filler.
     */
    public <T> Function<T, T> defaultFiller(Context<T> context);
}
