package de.pislaru.sergiu.booklibrary.aws;

public class AwsException extends RuntimeException {

    public AwsException() {
        super();
    }

    public AwsException(String message) {
        super(message);
    }

    public AwsException(String message, Throwable cause) {
        super(message, cause);
    }
}
