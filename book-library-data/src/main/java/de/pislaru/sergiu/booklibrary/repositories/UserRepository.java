package de.pislaru.sergiu.booklibrary.repositories;

import de.pislaru.sergiu.booklibrary.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User getFirstByEmail(String email);
    public User getFirstByUserName(String email);
}
