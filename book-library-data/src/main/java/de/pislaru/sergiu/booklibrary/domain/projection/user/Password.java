package de.pislaru.sergiu.booklibrary.domain.projection.user;

public final class Password {

    private final String password;

    public Password(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " {" +
                "Password=[************]}";
    }

    public String getPassword() {return password;}
}
