package de.pislaru.sergiu.booklibrary.security;

public interface AuthenticationService {
    String authenticate(String userName, char[] password);
    void setTokenAuthenticatedUserToContext(String userName);
}
