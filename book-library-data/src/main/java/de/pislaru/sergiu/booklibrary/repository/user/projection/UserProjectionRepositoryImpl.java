package de.pislaru.sergiu.booklibrary.repository.user.projection;

import de.pislaru.sergiu.booklibrary.domain.projection.user.Password;
import de.pislaru.sergiu.booklibrary.domain.projection.user.PersonalDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class UserProjectionRepositoryImpl implements UserProjectionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<PersonalDetails> getPersonalDetailsByUserId(Long userId) {

        return entityManager.createQuery("""
            select new PersonalDetails(
                            u.id ,
                            u.username,
                            u.email,
                            u.firstName,
                            u.lastName,
                            u.birthDate,
                            u.avatar)
                    from User u
                    where u.id = :id
                    """, PersonalDetails.class)
                .setParameter("id", userId)
                .getResultStream()
                .findFirst();
    }

    @Override
    public Optional<Password> getPasswordByUserId(Long userId) {
        return entityManager.createQuery("""
            select new Password(
                            u.password)
                    from User u
                    where u.id = :id
                    """, Password.class)
                .setParameter("id", userId)
                .getResultStream()
                .findFirst();
    }
}
