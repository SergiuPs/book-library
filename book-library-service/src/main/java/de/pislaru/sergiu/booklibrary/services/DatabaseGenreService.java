package de.pislaru.sergiu.booklibrary.services;

import de.pislaru.sergiu.booklibrary.model.book.Genre;
import de.pislaru.sergiu.booklibrary.model.book.GenreInfo;
import de.pislaru.sergiu.booklibrary.repositories.book.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseGenreService implements GenreService {

    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    public DatabaseGenreService(GenreRepository genreRepository, ModelMapper modelMapper) {
        this.genreRepository = genreRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GenreInfo> getAll() {
        List<GenreInfo> genres = new ArrayList<>();
        genreRepository.findAll().iterator().forEachRemaining(genre -> genres.add(modelMapper.map(genre, GenreInfo.class)));
        return genres;
    }

    @Override
    public GenreInfo findById(Long id) {
        return modelMapper.map(genreRepository.findById(id), GenreInfo.class);
    }

    @Override
    public GenreInfo save(GenreInfo genreInfo) {
        Genre genre = modelMapper.map(genreInfo, Genre.class);
        return modelMapper.map(genreRepository.save(genre), GenreInfo.class);
    }

    @Override
    public boolean delete(Long id) {
        genreRepository.deleteById(id);
        return true;
    }
}
