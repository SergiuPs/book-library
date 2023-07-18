package de.pislaru.sergiu.booklibrary.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityAuditorAware implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        return  Optional.ofNullable(SecurityUserHolder.getIdOfLoggedInUser());
    }
}
