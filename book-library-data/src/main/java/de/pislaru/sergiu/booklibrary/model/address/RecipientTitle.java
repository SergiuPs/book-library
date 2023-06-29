package de.pislaru.sergiu.booklibrary.model.address;

public enum RecipientTitle {

    MR("Mr."),
    MS("Mrs./Ms");

    private final String title;

    RecipientTitle(String title) {this.title = title;}

    public String getTitle() {return title;}
}
