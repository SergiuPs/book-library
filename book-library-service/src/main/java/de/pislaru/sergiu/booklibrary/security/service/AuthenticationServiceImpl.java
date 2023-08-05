package de.pislaru.sergiu.booklibrary.security.service;

import de.pislaru.sergiu.booklibrary.security.exception.PrincipalNotFoundException;
import de.pislaru.sergiu.booklibrary.security.SecurityUserHolder;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(String userName, char[] password) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, String.valueOf(password))
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        return auth;
    }

    @Override
    public boolean passwordOfAuthenticatedUserMatches(char[] password) {
        String userPassword = SecurityUserHolder.getPasswordOfTheAuthenticatedUser()
                .orElseThrow(() -> new PrincipalNotFoundException("Password of authenticated user not found"));
        return passwordEncoder.matches(String.valueOf(password), userPassword);
    }
}
