package de.pislaru.sergiu.booklibrary.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public final class SecurityUserHolder {

    private SecurityUserHolder() {
    };

    public static Long getIdOfLoggedInUser() {
        return getLoggedInUser().user().getId();
    }

    private static SecurityUser getLoggedInUser() {
        return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
