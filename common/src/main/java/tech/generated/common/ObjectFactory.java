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

import tech.generated.common.engine.spi.summner.ObjectContext;

/**
 * Object builder factory for creating objects.
 *
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ObjectFactory {

    /**
     * Build object of selected <code>clazz</code>.
     * @param clazz class of object to be build.
     * @param <T> type of new object.
     * @return new object instance.
     * @throws NewInstanceException if there was error while object creating.
     */
    public default <T> T build(Class<T> clazz) throws NewInstanceException {
        return this.build(Init.builder(clazz).build());
    }

    /**
     * Build object with parameters selected in context.
     *
     * @param context context to constract.
     * @return created object.
     * @throws NewInstanceException if there was error while object creating.
     */
    public default <T> T build(Init<T> context) throws NewInstanceException {
        return this.buildContext(context).get();
    }

    /**
     * Build object of <code>clazz</code> type.
     *
     * @param context context to constract.
     * @return Context of created object.
     * @throws NewInstanceException if there was error while object creating.
     */
    public <T> ObjectContext<T> buildContext(Init<T> context) throws NewInstanceException;
}
