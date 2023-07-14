package de.pislaru.sergiu.booklibrary.model.user;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof SecurityCode that) || !super.equals(object)) {
            return false;
        }

        return  Objects.equals(this.code, that.code) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, email, expirationDate.hashCode());
    }

    @Override
    public String toString() {
        return "SecurityCode {"
                + "code=" + code
                + ", email=" + email
                + ", expiration-date=" + expirationDate
                + "}"
                + super.toString();
    }

    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public LocalDateTime getExpirationDate() {return expirationDate;}
    public void setExpirationDate(LocalDateTime expirationDate) {this.expirationDate = expirationDate;}
}
