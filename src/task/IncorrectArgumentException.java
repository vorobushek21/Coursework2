package task;

public class IncorrectArgumentException extends Exception {

    private String argument;

    public IncorrectArgumentException(String argument) {
        this.argument = argument;
    }

    public IncorrectArgumentException(String message, String argument) {
        super(message);
        this.argument = argument;
    }

    public IncorrectArgumentException(String message, Throwable cause, String argument) {
        super(message, cause);
        this.argument = argument;
    }

    public IncorrectArgumentException(Throwable cause, String argument) {
        super(cause);
        this.argument = argument;
    }

    public IncorrectArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String argument) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.argument = argument;
    }
}
