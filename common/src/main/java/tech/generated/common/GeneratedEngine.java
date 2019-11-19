package tech.generated.common;

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
}
