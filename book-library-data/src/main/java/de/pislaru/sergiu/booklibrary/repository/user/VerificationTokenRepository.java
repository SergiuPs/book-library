package de.pislaru.sergiu.booklibrary.repository.user;

import de.pislaru.sergiu.booklibrary.domain.entity.user.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}
