package de.pislaru.sergiu.booklibrary.filters;

import de.pislaru.sergiu.booklibrary.constants.RestApiConstants;
import de.pislaru.sergiu.booklibrary.security.AuthenticationService;

import de.pislaru.sergiu.booklibrary.utils.JwtUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.BadCredentialsException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTTokenValidatorFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final AuthenticationService authenticationService;

    public JWTTokenValidatorFilter(JwtUtils jwtUtils, AuthenticationService authenticationService) {
        this.jwtUtils = jwtUtils;
        this.authenticationService = authenticationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String jwtToken = request.getHeader("Authorization");

        if (jwtToken != null && jwtUtils.isJwtTokenValid(jwtToken)) {
            try {
                String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
                authenticationService.setTokenAuthenticatedUserToContext(username);
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
