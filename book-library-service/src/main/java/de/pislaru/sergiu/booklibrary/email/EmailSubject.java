package de.pislaru.sergiu.booklibrary.email;

public enum EmailSubject {

    REGISTRATION_CONFIRMATION("Registration confirmation"),
    SECURITY_CODE("Your Spring-Library code:"),
    PASSWORD_RESET("Reset your password");

    private final String value;

    EmailSubject(String value) {
        this.value = value;
    }

    public String getValue() {return value;}
}
