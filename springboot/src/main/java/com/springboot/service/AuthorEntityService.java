package com.springboot.service;

import com.springboot.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorEntityService {
    Author save (Author author);
    List<Author>getAllActiveAuthors();

    void deleteAuthor(String authorID);

    Optional getAuthorById(String authorId);
}
