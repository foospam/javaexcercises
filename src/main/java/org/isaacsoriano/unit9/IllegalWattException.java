package org.isaacsoriano.unit9;


public class IllegalWattException extends RuntimeException{
    public IllegalWattException() {
        super();
    }

    public IllegalWattException(String message) {
        super(message);
    }

    public IllegalWattException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalWattException(Throwable cause) {
        super(cause);
    }
}
