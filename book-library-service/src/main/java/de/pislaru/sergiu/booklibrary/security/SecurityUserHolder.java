package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.model.security.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserHolder implements AuthenticationService {
    @Override
    public SecurityUser getLoggedInUser() {
        return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
