package de.pislaru.sergiu.booklibrary.services;

import de.pislaru.sergiu.booklibrary.model.book.Genre;
import de.pislaru.sergiu.booklibrary.model.book.GenreInfo;
import de.pislaru.sergiu.booklibrary.repositories.book.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DatabaseGenreService implements GenreService {

    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    public DatabaseGenreService(GenreRepository genreRepository, ModelMapper modelMapper) {
        this.genreRepository = genreRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public GenreInfo save(GenreInfo genreInfo) {
        Genre genre = modelMapper.map(genreInfo, Genre.class);
        return modelMapper.map(genreRepository.save(genre), GenreInfo.class);
    }
}
