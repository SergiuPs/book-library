package de.pislaru.sergiu.booklibrary.repository.user;

import de.pislaru.sergiu.booklibrary.domain.entity.user.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
