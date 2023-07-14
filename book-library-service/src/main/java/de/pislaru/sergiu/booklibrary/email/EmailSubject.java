package de.pislaru.sergiu.booklibrary.email;

public enum EmailSubject {

    REGISTRATION_CONFIRMATION("Registration confirmation"),
    SECURITY_CODE("Your Spring-Library code:");

    private final String value;

    EmailSubject(String value) {
        this.value = value;
    }

    public String getValue() {return value;}
}
