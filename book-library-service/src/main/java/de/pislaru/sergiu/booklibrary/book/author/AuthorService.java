package de.pislaru.sergiu.booklibrary.book.author;

import de.pislaru.sergiu.booklibrary.book.author.dto.AuthorDTO;
import org.springframework.data.domain.Page;

public interface AuthorService {

    public Page<AuthorDTO> getAll(Integer pageNo, Integer pageSize, String sortCriteria);

}
