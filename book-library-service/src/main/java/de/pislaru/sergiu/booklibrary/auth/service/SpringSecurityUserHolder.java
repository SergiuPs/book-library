package de.pislaru.sergiu.booklibrary.security.service;


import de.pislaru.sergiu.booklibrary.security.SecurityUser;
import de.pislaru.sergiu.booklibrary.security.service.SecurityUserHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class SpringSecurityUserHolder implements SecurityUserHolder {

    private SpringSecurityUserHolder() {
    }

    public Optional<SecurityUser> getAuthenticatedUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof SecurityUser) {
            return Optional.of((SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
        return Optional.empty();
    }

    public Optional<Long> getIdOfTheAuthenticatedUser() {
        return getAuthenticatedUser().map(SecurityUser::getId);
    }

    public Optional<String> getPasswordOfTheAuthenticatedUser() {
        return getAuthenticatedUser().map(SecurityUser::getPassword);
    }

    public Optional<String> getEmailOfTheAuthenticatedUser() {
        return getAuthenticatedUser().map(SecurityUser::getEmail);
    }

}
