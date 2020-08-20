package tech.generated.common;

import tech.generated.common.path.Path;

/**
 * Context for processing generated objects.
 *
 * @param <T> type of the object.
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Context<T> extends Path<T, Context<T>> {
    public Bindings getBindings();

    public GeneratedEngine getGeneratedEngine();
}
