package de.pislaru.sergiu.booklibrary.repository.user;

import de.pislaru.sergiu.booklibrary.domain.entity.user.User;
import de.pislaru.sergiu.booklibrary.repository.user.projection.UserProjectionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>, UserProjectionRepository {

    @Override
    Page<User> findAll(Pageable pageable);

    Optional<User> findByEmail(String email);

    boolean existsUserByEmail(String email);

    Optional<User> findByUsername(String username);

    @Query("SELECT p FROM User p WHERE CONCAT(p.firstName, ' ', p.lastName, ' ', p.email, ' ', p.username) LIKE %?1%")
    Page<User> search(String keyword, Pageable pageable);

    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    void updatePassword(@Param(value = "id") Long id, @Param(value = "password") String password);
}
