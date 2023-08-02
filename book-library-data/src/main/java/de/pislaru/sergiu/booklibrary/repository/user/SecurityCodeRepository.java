package de.pislaru.sergiu.booklibrary.repositories.user;

import de.pislaru.sergiu.booklibrary.domain.entity.user.SecurityCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SecurityCodeRepository extends CrudRepository<SecurityCode, Long> {
    Set<SecurityCode> findAllByCodeAndEmail(String code, String email);
}
