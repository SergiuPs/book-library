package de.pislaru.sergiu.booklibrary.model.user;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class SecurityCode extends BaseEntity {

    private static final int EXPIRATION = 10;

    @Size(min = 6, max = 6)
    private String code;

    @NotNull
    private String email;

    @NotNull
    private LocalDateTime expirationDate;

    public SecurityCode() {
    }

    public SecurityCode(String code, String email) {
        this.code = code;
        this.email = email;
        this.expirationDate = calculateExpiration();
    }

    private LocalDateTime calculateExpiration() {
        return LocalDateTime.now().plusMinutes(EXPIRATION);
    }

    @Override
    public String toString() {
        return "SecurityCode { "
                + super.toString()
                + ", code=" + code
                + ", email=" + email
                + ", expiration-date=" + expirationDate
                + "}";
    }

    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public LocalDateTime getExpirationDate() {return expirationDate;}
    public void setExpirationDate(LocalDateTime expirationDate) {this.expirationDate = expirationDate;}
}
