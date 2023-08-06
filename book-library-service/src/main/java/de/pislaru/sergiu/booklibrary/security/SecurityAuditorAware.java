package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.auth.SecurityUser;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityAuditorAware implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        return (principal instanceof SecurityUser) ? Optional.of(((SecurityUser) principal).getId()) : Optional.empty();
    }
}
