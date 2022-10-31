package de.pislaru.sergiu.booklibrary.repositories;

import de.pislaru.sergiu.booklibrary.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User getFirstByEmail(String email);
    public User getFirstByUserName(String email);
    public Set<User> getAllByRolesLevelLessThanEqual(byte level);
}
