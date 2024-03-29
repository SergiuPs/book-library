package de.pislaru.sergiu.booklibrary.auth.jwt;

import de.pislaru.sergiu.booklibrary.auth.SecurityUser;

import de.pislaru.sergiu.booklibrary.auth.service.AuthenticationService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class JWTAuthenticationService implements TokenAuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationService.class);

    @Value("${book.library.jwt.jwtKey}")
    private String jwtKey;

    @Value("${book.library.jwt.jwtExpiresAfter}")
    private Long jwtExpiresAfter;

    private final AuthenticationService authenticationService;
    private final UserDetailsService userDetailsService;

    public JWTAuthenticationService(AuthenticationService authenticationService, UserDetailsService userDetailsService) {
        this.authenticationService = authenticationService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public String authenticate(String username, char[] password) {
        Authentication auth = authenticationService.authenticate(username, password);
        return generateJwtToken(auth);
    }

    @Override
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getKey()).build().parse(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        throw new BadCredentialsException("Invalid token");
    }

    @Override
    public void setTokenAuthenticatedUserToContext(String token) {
        String username = getUsername(token);
        UserDetails user = userDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private String generateJwtToken(Authentication auth) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + jwtExpiresAfter);
        SecurityUser user = (SecurityUser) auth.getPrincipal();

        return  Jwts.builder().setIssuer("Spring-Library")
                .setSubject(user.getUsername())
                .claim("id", user.getId())
                .claim("authorities", populateAuthorities(auth.getAuthorities()))
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(jwtKey.getBytes(StandardCharsets.UTF_8));
    }

    private String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }
}
