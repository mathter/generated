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
