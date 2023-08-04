package de.pislaru.sergiu.booklibrary.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class SecurityUserHolder {

    private SecurityUserHolder() {
    }

    public static Optional<Long> idOfLoggedInUser() {
        return loggedInUser().map(SecurityUser::getId);
    }

    private static Optional<SecurityUser> loggedInUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof SecurityUser) {
            return Optional.of((SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
        return Optional.empty();
    }

}
