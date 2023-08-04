package de.pislaru.sergiu.booklibrary.security;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public final class SecurityUserHolder {

    private SecurityUserHolder() {
    }

    public static Optional<Long> getIdOfTheAuthenticatedUser() {
        return getAuthenticatedUser().map(SecurityUser::getId);
    }

    public static Optional<String> getPasswordOfTheAuthenticatedUser() {
        return getAuthenticatedUser().map(SecurityUser::getPassword);
    }

    public static Optional<String> getEmailOfTheAuthenticatedUser() {
        return getAuthenticatedUser().map(SecurityUser::getEmail);
    }

    private static Optional<SecurityUser> getAuthenticatedUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof SecurityUser) {
            return Optional.of((SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
        return Optional.empty();
    }

}
