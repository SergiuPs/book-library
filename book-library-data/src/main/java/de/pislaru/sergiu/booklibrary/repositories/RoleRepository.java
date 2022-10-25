package de.pislaru.sergiu.booklibrary.repositories;

import de.pislaru.sergiu.booklibrary.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    public Role getFirstByName(String name);
}
