package de.pislaru.sergiu.booklibrary.domain.entity.user;

public enum Roles {

    ROLE_SUPER_ADMIN("ROLE_SUPER_ADMIN"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_LIBRARY_MANAGER("ROLE_LIBRARY_MANAGER"),
    ROLE_LIBRARIAN("ROLE_LIBRARIAN"),
    ROLE_USER("ROLE_USER");

    private final String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {return name;}
}
