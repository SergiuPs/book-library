package de.pislaru.sergiu.booklibrary.repositories.book;

import de.pislaru.sergiu.booklibrary.domain.entity.book.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Page<Author> findAll(Pageable pageable);
}
