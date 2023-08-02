package de.pislaru.sergiu.booklibrary.domain.entity.user;

import de.pislaru.sergiu.booklibrary.domain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class VerificationToken extends BaseEntity {

    private static final int EXPIRATION = 60 * 24;

    @NotBlank
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @NotNull
    private LocalDateTime expirationDate;

    public VerificationToken() {
    }

    public VerificationToken(String token, User user) {
        this.token = token;
        this.user = user;
        this.expirationDate = calculateExpirationDate();
    }

    private LocalDateTime calculateExpirationDate() {
        return LocalDateTime.now().plusMinutes(EXPIRATION);
    }

    @Override
    public String toString() {
        return "VerificationToken { "
                + super.toString()
                + ", token=" + token
                + ", expiration-date=" + expirationDate
                + ", user {" + user
                + "}}";
    }

    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public LocalDateTime getExpirationDate() {return expirationDate;}
    public void setExpirationDate(LocalDateTime expirationDate) {this.expirationDate = expirationDate;}
}
