package com.inkpenbookspublisher.service;

import com.inkpenbookspublisher.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorEntityService {
    Author save(Author author);
    Optional<List<Author>>getAll();
    Optional getById(String id);
    boolean existsById(String id);

    Optional deleteById(String id);
}
