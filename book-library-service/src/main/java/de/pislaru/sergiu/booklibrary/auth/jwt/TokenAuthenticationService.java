package de.pislaru.sergiu.booklibrary.auth.jwt;

public interface TokenAuthenticationService {

    String authenticate(String username, char[] password);

    boolean isTokenValid(String token);

    void setTokenAuthenticatedUserToContext(String token);
}
