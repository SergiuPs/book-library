package de.pislaru.sergiu.booklibrary.repositories.book;

import de.pislaru.sergiu.booklibrary.model.book.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
}
