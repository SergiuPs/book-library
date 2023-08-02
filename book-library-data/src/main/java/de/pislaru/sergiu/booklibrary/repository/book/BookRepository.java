package de.pislaru.sergiu.booklibrary.repository.book;

import de.pislaru.sergiu.booklibrary.domain.entity.book.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
