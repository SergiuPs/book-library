package de.pislaru.sergiu.booklibrary.auth.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    Authentication authenticate(String username, char[] password);

    boolean passwordMatches(Long userId, char[] password);

}
