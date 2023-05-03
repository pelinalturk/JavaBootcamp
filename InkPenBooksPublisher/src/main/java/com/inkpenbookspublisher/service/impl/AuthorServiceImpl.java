package com.inkpenbookspublisher.service.impl;

import com.inkpenbookspublisher.model.Author;
import com.inkpenbookspublisher.model.dto.AuthorDto;
import static com.inkpenbookspublisher.model.mapper.AuthorMapper.AUTHOR_MAPPER;
import com.inkpenbookspublisher.model.request.CreateAuthorRequest;
import com.inkpenbookspublisher.service.AuthorEntityService;
import com.inkpenbookspublisher.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorEntityService authorEntityService;

    public AuthorServiceImpl(AuthorEntityService authorEntityService) {
        this.authorEntityService = authorEntityService;
    }

    @Override
    public AuthorDto saveAuthor(CreateAuthorRequest createAuthorRequest) {
        Author author = AUTHOR_MAPPER.createAuthor(createAuthorRequest);
        authorEntityService.save(author);
        return AUTHOR_MAPPER.convertToAuthorDto(author);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorEntityService.getAll().stream()
                .map(AUTHOR_MAPPER::convertToAuthorDto).collect(Collectors.toList());
    }

    @Override
    public Optional<AuthorDto> getAuthorById(String id) {
        Optional<Author> author = authorEntityService.getById(id);
        if (author.isPresent()) {
            return Optional.ofNullable(AUTHOR_MAPPER.convertToAuthorDto(author.get()));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsByAuthorId(String id) {
        return authorEntityService.existsById(id);
    }

    @Override
    public void deleteAuthorById(String id) {
        Optional<Author> author = authorEntityService.getById(id);
        if (author.isPresent()) {
            authorEntityService.deleteById(id);
        }
        // exception
    }
}
