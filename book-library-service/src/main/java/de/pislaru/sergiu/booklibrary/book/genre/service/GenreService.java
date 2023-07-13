package de.pislaru.sergiu.booklibrary.book.genre.service;

import de.pislaru.sergiu.booklibrary.book.genre.dto.GenreDTO;
import java.util.List;

public interface GenreService {
    GenreDTO findById(Long id);
    GenreDTO save(GenreDTO genreDTO);
    List<GenreDTO> getAll();
    boolean delete(Long id);
}
