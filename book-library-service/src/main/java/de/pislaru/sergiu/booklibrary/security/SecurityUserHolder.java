package de.pislaru.sergiu.booklibrary.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class SecurityUserHolder {

    private SecurityUserHolder() {
    };

    public static Optional<Long> getIdOfLoggedInUser() {
        return getLoggedInUser().map(SecurityUser::id);
    }

    private static Optional<SecurityUser> getLoggedInUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof SecurityUser) {
            return Optional.of((SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
        return Optional.empty();
    }

}
