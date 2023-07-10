package de.pislaru.sergiu.booklibrary.config;

import de.pislaru.sergiu.booklibrary.filters.JWTTokenValidatorFilter;
import de.pislaru.sergiu.booklibrary.security.AuthenticationService;
import de.pislaru.sergiu.booklibrary.utils.JwtUtils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    private final JwtUtils jwtUtils;
    private final AuthenticationService authenticationService;

    public WebSecurityConfig(JwtUtils jwtUtils, AuthenticationService authenticationService) {
        this.jwtUtils = jwtUtils;
        this.authenticationService = authenticationService;
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                cors().configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:3333"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(Arrays.asList("Authorization"));
                    config.setMaxAge(3600L);
                    return config;
                }).and()
                .csrf().disable()
                .addFilterBefore(new JWTTokenValidatorFilter(jwtUtils, authenticationService), BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/users").authenticated()
                .antMatchers("/", "/register").permitAll()
                .and().formLogin()
                .and().httpBasic();

        return http.build();
    }
}



