package course.springdata.introlab.exception;

public class NoneexistingEntityException extends RuntimeException {
    public NoneexistingEntityException() {
    }

    public NoneexistingEntityException(String message) {
        super(message);
    }

    public NoneexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneexistingEntityException(Throwable cause) {
        super(cause);
    }
}
