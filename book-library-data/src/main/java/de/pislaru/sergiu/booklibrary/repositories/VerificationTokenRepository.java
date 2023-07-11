package de.pislaru.sergiu.booklibrary.repositories;

import de.pislaru.sergiu.booklibrary.model.user.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
