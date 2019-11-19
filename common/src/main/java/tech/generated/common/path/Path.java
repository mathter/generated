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
package tech.generated.common.path;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

/**
 * Path class contains data for identified objects by same parameters, like this object name, value and another.
 *
 * @param <N> type of the object identified by this path.
 * @param <P> Type of container which contains object.
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Path<N, P extends Path<N, P>> {

    /**
     * Class of the object identified by this path.
     *
     * @return class of the object identified by this path.
     */
    public Class<N> clazz();

    /**
     * Object identified by this path.
     *
     * @return object identified by this path.
     */
    public N node();

    /**
     * Name of the object identified by this path.
     *
     * @return name of the object identified by this path.
     */
    public String name();

    /**
     * Parent path.
     *
     * @return parent path.
     */
    public Path<?, ? extends P> parent();

    /**
     * Child paths.
     *
     * @return child paths.
     */
    public Stream<Path<?, ?>> child();

    public default Stream<Path<?, ?>> stream() {
        Deque<Path<?, ?>> deque = new ArrayDeque<>();

        Path<?, ?> path = this;

        do {
            deque.push(path);
            path = path.parent();
        } while (path != null);

        return deque.stream();
    }
}
