package de.pislaru.sergiu.booklibrary.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface AuthenticationService {

    Authentication authenticate(String username, char[] password);

    boolean passwordOfAuthenticatedUserMatches(char[] password);

    Optional<UserDetails> getUserDetails(Long id);
}
