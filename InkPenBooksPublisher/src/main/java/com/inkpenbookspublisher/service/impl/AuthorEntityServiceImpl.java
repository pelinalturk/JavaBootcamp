package com.inkpenbookspublisher.service.impl;

import com.inkpenbookspublisher.model.Author;
import com.inkpenbookspublisher.repository.AuthorRepository;
import com.inkpenbookspublisher.service.AuthorEntityService;
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
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
