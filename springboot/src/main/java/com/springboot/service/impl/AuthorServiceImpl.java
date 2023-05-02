package com.springboot.service.impl;

import com.springboot.model.Author;
import com.springboot.model.dto.AuthorDto;
import static com.springboot.model.mapper.AuthorMapper.AUTHOR_MAPPER;
import com.springboot.model.request.CreateAuthorRequest;
import com.springboot.service.AuthorEntityService;
import com.springboot.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorEntityService authorEntityService;

    public AuthorServiceImpl(AuthorEntityService authorEntityService) {
        this.authorEntityService = authorEntityService;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> getAllAuthors = authorEntityService.getAllAuthors();
        return getAllAuthors.stream().map(AUTHOR_MAPPER::convertToAuthorDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDto createAuthor(CreateAuthorRequest createAuthorRequest) {
        Author author = AUTHOR_MAPPER.createAuthor(createAuthorRequest);
        author = authorEntityService.save(author);
        return AUTHOR_MAPPER.convertToAuthorDto(author);
    }
}
