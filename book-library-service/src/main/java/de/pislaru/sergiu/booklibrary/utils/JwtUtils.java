package de.pislaru.sergiu.booklibrary.utils;

import de.pislaru.sergiu.booklibrary.security.SecurityUserHolder;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${book.library.jwt.jwtKey}")
    private String jwtKey;

    @Value("${book.library.jwt.jwtExpiresAfter}")
    private Long jwtExpiresAfter;

    public String generateJwtToken(Authentication auth) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + jwtExpiresAfter);

        Long userId;
        if (SecurityUserHolder.idOfLoggedInUser().isPresent()) {
            userId = SecurityUserHolder.idOfLoggedInUser().get();
        } else {
            throw new InsufficientAuthenticationException("Logged in user was not set to context.");
        }
        return  Jwts.builder().setIssuer("Library-App")
                .setSubject(auth.getName())
                .claim("userId", userId)
                .claim("authorities", populateAuthorities(auth.getAuthorities()))
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(getKey())
                .compact();
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }

        return String.join(",", authoritiesSet);
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(jwtKey.getBytes(StandardCharsets.UTF_8));
    }

    public boolean isJwtTokenValid(String token) {
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

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

}
