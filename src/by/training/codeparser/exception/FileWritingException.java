package by.training.codeparser.exception;


/**
 * The type File writing exception.
 */
public class FileWritingException extends Exception {
    /**
     * Instantiates a new File writing exception.
     */
    public FileWritingException() {
        super();
    }

    /**
     * Instantiates a new File writing exception.
     *
     * @param message the message
     */
    public FileWritingException(String message) {
        super(message);
    }

    /**
     * Instantiates a new File writing exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public FileWritingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new File writing exception.
     *
     * @param cause the cause
     */
    public FileWritingException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new File writing exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    protected FileWritingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
