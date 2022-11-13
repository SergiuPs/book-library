package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.model.security.SecurityUser;

public interface AuthenticationService {
    SecurityUser getLoggedInUser();
}
