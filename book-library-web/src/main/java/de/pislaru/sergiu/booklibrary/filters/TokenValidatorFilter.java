package de.pislaru.sergiu.booklibrary.filters;

import de.pislaru.sergiu.booklibrary.constants.RestApiConstants;

import de.pislaru.sergiu.booklibrary.security.service.TokenAuthenticationService;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.BadCredentialsException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenValidatorFilter extends OncePerRequestFilter {

    private final TokenAuthenticationService authenticationService;

    public TokenValidatorFilter(TokenAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String jwtToken = request.getHeader("Authorization");

        if (jwtToken != null && authenticationService.isTokenValid(jwtToken)) {
            try {
                authenticationService.setTokenAuthenticatedUserToContext(jwtToken);
            } catch (Exception e) {
                throw new BadCredentialsException("Invalid Token received!");
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().equals(RestApiConstants.CURRENT_VERSION + "/login");
    }
}
