package de.pislaru.sergiu.booklibrary.book.author;

import de.pislaru.sergiu.booklibrary.model.book.Author;
import de.pislaru.sergiu.booklibrary.book.author.dto.AuthorDTO;
import de.pislaru.sergiu.booklibrary.repositories.book.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<AuthorDTO> getAll(Integer pageNo, Integer pageSize, String sortCriteria) {
        Pageable paging;

        if (sortCriteria != null && !sortCriteria.isEmpty()) {
            int indexOfSeparator = sortCriteria.indexOf(':');
            String criteria = sortCriteria.substring(0, indexOfSeparator);
            String direction = sortCriteria.substring(indexOfSeparator+1);
            Sort sort;

            if (direction.equals("asc")) {
                sort = Sort.by(criteria).ascending();
            } else {
                sort = Sort.by(criteria).descending();
            }
            paging = PageRequest.of(pageNo, pageSize, sort);

        } else {
            paging = PageRequest.of(pageNo, pageSize);
        }
        Page<Author> pagedResult = authorRepository.findAll(paging);

        return pagedResult.map(author -> modelMapper.map(author, AuthorDTO.class));
    }
}
