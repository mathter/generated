package tech.generated.common.engine.reflect;

/**
 * Interface represents accessing to the object.
 *
 * @param <T> type of the value.
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Accessor<T> {

    /**
     * Return underlying value.
     *
     * @return return value.
     */
    public T get();

    /**
     * Set underlying value.
     *
     * @param value value.
     */
    public void set(T value);
}
