package de.pislaru.sergiu.booklibrary.security.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    Authentication authenticate(String username, char[] password);

    boolean passwordOfAuthenticatedUserMatches(char[] password);

}
