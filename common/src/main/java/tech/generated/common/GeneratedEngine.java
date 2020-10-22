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

import tech.generated.common.dsl.Dsl;

/**
 * Engine class for generated framework.
 *
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface GeneratedEngine {

    /**
     * Method returns object factory.
     *
     * @return object factory.
     */
    public abstract ObjectFactory objectFactory();

    /**
     * Method returns {@linkplain InstanceBuilderFactory}.
     *
     * @return instance of a {@linkplain InstanceBuilderFactory}.
     */
    public abstract InstanceBuilderFactory instanceBuilderFactory();

    /**
     * Method returns {@linkplain FillerFactory}.
     *
     * @return instance of a {@linkplain FillerFactory}.
     */
    public abstract FillerFactory fillerFactory();

    /**
     * Method create configuration factory.
     *
     * @return configuation factory.
     */
    public Dsl dsl();
}
