package de.pislaru.sergiu.booklibrary.config;

import de.pislaru.sergiu.booklibrary.aspects.CreatedByAspect;
import de.pislaru.sergiu.booklibrary.security.AuthenticationService;
import de.pislaru.sergiu.booklibrary.security.SecurityUserHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectsConfiguration {

    @Bean
    public CreatedByAspect createdByAspect() {
        return new CreatedByAspect(authenticationService());
    }

    @Bean
    public AuthenticationService authenticationService() {
        return new SecurityUserHolder();
    }
}
