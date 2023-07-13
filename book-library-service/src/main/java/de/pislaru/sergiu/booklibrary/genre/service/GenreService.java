package de.pislaru.sergiu.booklibrary.services;

import de.pislaru.sergiu.booklibrary.dto.book.GenreDTO;
import java.util.List;

public interface GenreService {
    GenreDTO findById(Long id);
    GenreDTO save(GenreDTO genreDTO);
    List<GenreDTO> getAll();
    boolean delete(Long id);
}
