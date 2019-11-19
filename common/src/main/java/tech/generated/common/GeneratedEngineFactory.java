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

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Stream;

/**
 * Class is a factory of a generated engines.
 *
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class GeneratedEngineFactory {

    /**
     * Default engine name.
     */
    private static final String DEFAULT_ENGINE_NAME = tech.generated.common.engine.spi.summner.GeneratedEngineFactory.NAME;

    /**
     * Method creates new generated engine instance using parameters.
     *
     * @param params parameters passed to the engine.
     * @return genetated engine.
     */
    protected abstract GeneratedEngine newEngine(Object... params);

    public abstract String getName();

    public static final GeneratedEngine newInstance(String name, Object... params) {
        final GeneratedEngineFactory factory = GeneratedEngineFactory.getInstance(name != null ? name : DEFAULT_ENGINE_NAME);
        final GeneratedEngine engine = factory.newEngine(params);

        return engine;
    }

    private static final GeneratedEngineFactory getInstance(String name) {
        GeneratedEngineFactory instance = null;
        final ServiceLoader<GeneratedEngineFactory> loader = ServiceLoader.load(GeneratedEngineFactory.class);

        if (name != null) {
            for (GeneratedEngineFactory factory : loader) {

                if (name.equals(factory.getName())) {
                    instance = factory;
                    break;
                }
            }
        } else {
            instance = getInstance(DEFAULT_ENGINE_NAME);
        }

        if (instance == null) {
            throw new IllegalArgumentException(name + " is invalid engine name!");
        }

        return instance;
    }

    public static final Stream<String> registeredEngineNames() {

        final List<String> names = new ArrayList<>();
        final ServiceLoader<GeneratedEngineFactory> serviceLoader = ServiceLoader.load(GeneratedEngineFactory.class);

        for (GeneratedEngineFactory factory : serviceLoader) {
            names.add(factory.getName());
        }

        return names.stream();
    }
}
