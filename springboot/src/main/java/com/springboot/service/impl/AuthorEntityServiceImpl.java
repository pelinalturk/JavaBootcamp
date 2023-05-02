package com.springboot.service.impl;

import com.springboot.model.Author;
import com.springboot.repository.AuthorRepository;
import com.springboot.service.AuthorEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorEntityServiceImpl implements AuthorEntityService {
    private final AuthorRepository authorRepository;

    public AuthorEntityServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
