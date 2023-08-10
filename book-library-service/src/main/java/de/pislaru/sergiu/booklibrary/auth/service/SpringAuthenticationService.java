package de.pislaru.sergiu.booklibrary.auth.service;

import de.pislaru.sergiu.booklibrary.auth.exception.PasswordNotFoundException;
import de.pislaru.sergiu.booklibrary.repository.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SpringAuthenticationService implements AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public SpringAuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
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
    public boolean passwordMatches(Long userId, char[] password) {
        String userPassword = userRepository.getPasswordByUserId(userId)
                .orElseThrow(() -> new PasswordNotFoundException("No password found in database for user: " + userId))
                .getPassword();
        return passwordEncoder.matches(String.valueOf(password), userPassword);
    }
}
