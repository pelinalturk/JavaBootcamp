package com.inkpenbookspublisher.service;

import com.inkpenbookspublisher.model.Author;
import com.inkpenbookspublisher.model.dto.AuthorDto;
import com.inkpenbookspublisher.model.dto.AuthorWithBookDto;
import com.inkpenbookspublisher.model.request.CreateAuthorRequest;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorDto saveAuthor(CreateAuthorRequest createAuthorRequest);
    List<AuthorDto>getAllAuthors();
    Optional<AuthorDto> getAuthorById(String id);
    boolean existsByAuthorId(String id);

    void deleteAuthorById(String id);

    List<AuthorWithBookDto> getAllBooksWithAuthor(String authorId);

}
