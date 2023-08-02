package de.pislaru.sergiu.booklibrary.repositories.user;

import de.pislaru.sergiu.booklibrary.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Override
    Page<User> findAll(Pageable pageable);
    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);
    @Query("SELECT p FROM User p WHERE CONCAT(p.firstName, ' ', p.lastName, ' ', p.email, ' ', p.userName) LIKE %?1%")
    Page<User> search(String keyword, Pageable pageable);
    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    void updatePassword(@Param(value = "id") Long id, @Param(value = "password") String password);

}
