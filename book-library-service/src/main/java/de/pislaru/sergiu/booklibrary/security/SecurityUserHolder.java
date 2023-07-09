package de.pislaru.sergiu.booklibrary.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserHolder {

    public static SecurityUser getLoggedInUser() {
        return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static Long getIdOfLoggedInUser() {
        return getLoggedInUser().user().getId();
    }
    public Long getId() {
        return getLoggedInUser().user().getId();
    }

}
