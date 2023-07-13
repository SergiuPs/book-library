package de.pislaru.sergiu.booklibrary.book.genre.service;

import de.pislaru.sergiu.booklibrary.model.book.Genre;
import de.pislaru.sergiu.booklibrary.book.genre.dto.GenreDTO;
import de.pislaru.sergiu.booklibrary.repositories.book.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    public GenreServiceImpl(GenreRepository genreRepository, ModelMapper modelMapper) {
        this.genreRepository = genreRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GenreDTO> getAll() {
        List<GenreDTO> genres = new ArrayList<>();
        genreRepository.findAll().iterator().forEachRemaining(genre -> genres.add(modelMapper.map(genre, GenreDTO.class)));
        return genres;
    }

    @Override
    public GenreDTO findById(Long id) {
        return modelMapper.map(genreRepository.findById(id), GenreDTO.class);
    }

    @Override
    public GenreDTO save(GenreDTO genreDTO) {
        Genre genre = modelMapper.map(genreDTO, Genre.class);
        return modelMapper.map(genreRepository.save(genre), GenreDTO.class);
    }

    @Override
    public boolean delete(Long id) {
        genreRepository.deleteById(id);
        return true;
    }
}
