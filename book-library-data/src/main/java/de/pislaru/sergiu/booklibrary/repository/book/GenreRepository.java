package de.pislaru.sergiu.booklibrary.repository.book;

import de.pislaru.sergiu.booklibrary.domain.entity.book.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
}
