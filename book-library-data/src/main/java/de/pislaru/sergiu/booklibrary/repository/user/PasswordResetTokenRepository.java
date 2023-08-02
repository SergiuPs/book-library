package de.pislaru.sergiu.booklibrary.repositories.user;

import de.pislaru.sergiu.booklibrary.domain.entity.user.PasswordResetToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);
}
