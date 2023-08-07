package de.pislaru.sergiu.booklibrary.auth.exception;

public class PasswordNotFoundException extends RuntimeException {

    public PasswordNotFoundException() {
        super();
    }

    public PasswordNotFoundException(String message) {
        super(message);
    }

    public PasswordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
