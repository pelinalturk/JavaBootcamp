package com.springboot.service;

import com.springboot.model.Author;

import java.util.List;

public interface AuthorEntityService {
    Author save (Author author);
    List<Author>getAllAuthors();
}
