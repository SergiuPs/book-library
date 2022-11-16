package de.pislaru.sergiu.booklibrary.services;

import de.pislaru.sergiu.booklibrary.model.book.GenreInfo;
import java.util.List;

public interface GenreService {
    GenreInfo findById(Long id);
    GenreInfo save(GenreInfo genreInfo);
    List<GenreInfo> getAll();
    boolean delete(Long id);
}
