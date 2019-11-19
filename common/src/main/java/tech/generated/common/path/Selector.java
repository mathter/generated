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
public interface Selector<P extends Path<?, ? extends P>> extends Predicate<P>, Cloneable {

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

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Object#clone()
     */
    public Selector<P> clone() throws CloneNotSupportedException;
}
