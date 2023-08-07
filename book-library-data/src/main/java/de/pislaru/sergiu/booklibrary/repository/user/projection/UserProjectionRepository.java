package de.pislaru.sergiu.booklibrary.repository.user.projection;

import de.pislaru.sergiu.booklibrary.domain.projection.user.Password;
import de.pislaru.sergiu.booklibrary.domain.projection.user.PersonalDetails;

import java.util.Optional;

public interface UserProjectionRepository {

    Optional<PersonalDetails> getPersonalDetailsByUserId(Long userId);

    Optional<Password> getPasswordByUserId(Long userId);

}
