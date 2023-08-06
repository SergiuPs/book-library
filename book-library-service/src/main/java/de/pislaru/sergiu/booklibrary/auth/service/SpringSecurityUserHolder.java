package de.pislaru.sergiu.booklibrary.auth.service;


import de.pislaru.sergiu.booklibrary.auth.SecurityUser;
import de.pislaru.sergiu.booklibrary.auth.exception.PrincipalNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public final class SpringSecurityUserHolder implements SecurityUserHolder {

    private SpringSecurityUserHolder() {
    }

    @Override
    public SecurityUser getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if (!(principal instanceof SecurityUser)) {
            throw new PrincipalNotFoundException("Unauthenticated");
        }
        return (SecurityUser) principal;
    }

    @Override
    public Long getIdOfTheAuthenticatedUser() {
        return getAuthenticatedUser().getId();
    }

    @Override
    public String getEmailOfTheAuthenticatedUser() {
        return getAuthenticatedUser().getEmail();
    }

}
