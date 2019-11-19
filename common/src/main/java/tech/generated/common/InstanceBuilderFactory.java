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
