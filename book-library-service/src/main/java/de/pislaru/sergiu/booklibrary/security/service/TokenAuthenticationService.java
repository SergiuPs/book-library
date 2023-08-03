package de.pislaru.sergiu.booklibrary.security.service;

public interface TokenAuthenticationService {

    String authenticate(String username, char[] password);

    boolean isTokenValid(String token);

    void setTokenAuthenticatedUserToContext(String token);
}
