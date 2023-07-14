package de.pislaru.sergiu.booklibrary.email;

public enum EmailSender {

    NO_REPLY("spring-library@gmx.de"),
    CUSTOMER_SERVICE("spring-library@gmx.de");

    private final String value;

    EmailSender(String value) {
        this.value = value;
    }

    public String getValue() {return value;}
}
