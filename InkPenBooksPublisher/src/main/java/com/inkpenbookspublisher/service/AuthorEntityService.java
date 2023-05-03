package com.inkpenbookspublisher.service;

import com.inkpenbookspublisher.model.Author;

import java.util.List;

public interface AuthorEntityService {
    Author save(Author author);
    List<Author>getAll();
}
