package de.pislaru.sergiu.booklibrary.auth.exception;

public class PrincipalNotFoundException extends RuntimeException {

    public PrincipalNotFoundException() {
        super();
    }

    public PrincipalNotFoundException(String message) {
        super(message);
    }

    public PrincipalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
