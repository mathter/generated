package tech.generated.common;

/**
 * Root exception for project.
 *
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public class GeneratedException extends RuntimeException {

    public GeneratedException() {
    }

    public GeneratedException(String message) {
        super(message);
    }

    public GeneratedException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneratedException(Throwable cause) {
        super(cause);
    }

    public GeneratedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
