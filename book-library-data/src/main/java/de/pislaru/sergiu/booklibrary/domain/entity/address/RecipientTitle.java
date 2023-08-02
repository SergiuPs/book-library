package de.pislaru.sergiu.booklibrary.domain.entity.address;

public enum RecipientTitle {

    MR("Mr."),
    MS("Mrs./Ms");

    private final String value;

    RecipientTitle(String value) {this.value = value;}

    public String getValue() {return value;}
}
