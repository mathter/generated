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

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Class represents selectors.
 *
 * @param <P> type of {@linkplain Path} that the selector works with.
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Selector<P extends Path<?, ? extends P>> extends Predicate<P> {

    /**
     * Name of the selector.
     *
     * @return name of the selector.
     */
    public String name();

    /**
     * Next selector in selector chain.
     *
     * @return selector.
     */
    public Selector<P> next();

    /**
     * Metrics of the selector.
     *
     * @return metrics.
     */
    public long metrics();

    /**
     * Chain of selectors.
     *
     * @return chain.
     */
    public default Stream<Selector<P>> chain() {
        final Iterator<Selector<P>> iterator = new Iterator<Selector<P>>() {
            private Selector<P> nextElement = Selector.this;

            @Override
            public boolean hasNext() {
                return this.nextElement != null;
            }

            @Override
            public Selector<P> next() {
                try {
                    return this.nextElement;
                } finally {
                    this.nextElement = this.nextElement.next();
                }
            }
        };

        final Spliterator<Selector<P>> selectorSpliterator = Spliterators.spliteratorUnknownSize(iterator, Spliterator.NONNULL | Spliterator.IMMUTABLE);

        return StreamSupport.stream(selectorSpliterator, false);
    }
}
