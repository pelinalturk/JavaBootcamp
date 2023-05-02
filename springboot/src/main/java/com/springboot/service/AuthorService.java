package com.springboot.service;


import com.springboot.model.dto.AuthorDto;
import com.springboot.model.request.CreateAuthorRequest;

import java.util.List;

public interface AuthorService {
    List<AuthorDto>getAllActiveAuthors();
    AuthorDto createAuthor(CreateAuthorRequest createAuthorRequest);
    void deleteAuthor(String authorId);
}
