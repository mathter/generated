package tech.generated.common;

/**
 * This exception indicates error while creating object instance.
 *
 * @author <a href="mailto:mathter@mail.ru">mathter</a>
 * @version 1.0.0
 * @since 1.0.0
 */
public class NewInstanceException extends GeneratedException {
    public NewInstanceException() {
    }

    public NewInstanceException(String message) {
        super(message);
    }

    public NewInstanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewInstanceException(Throwable cause) {
        super(cause);
    }

    public NewInstanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
