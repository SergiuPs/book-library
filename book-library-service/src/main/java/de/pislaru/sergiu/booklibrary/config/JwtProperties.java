package de.pislaru.sergiu.booklibrary.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "book.library.jwt")
public class JwtProperties {

    private String jwtKey;
    private Long jwtExpiresAfter;

    public String getJwtKey() {return jwtKey;}
    public void setJwtKey(String jwtKey) {this.jwtKey = jwtKey;}
    public Long getJwtExpiresAfter() {return jwtExpiresAfter;}
    public void setJwtExpiresAfter(Long jwtExpiresAfter) {this.jwtExpiresAfter = jwtExpiresAfter;}
}
