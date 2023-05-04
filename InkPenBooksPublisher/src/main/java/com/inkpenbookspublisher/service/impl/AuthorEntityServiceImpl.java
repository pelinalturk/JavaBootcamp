package com.inkpenbookspublisher.service.impl;

import com.inkpenbookspublisher.model.Author;
import com.inkpenbookspublisher.repository.AuthorRepository;
import com.inkpenbookspublisher.service.AuthorEntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<List<Author>> getAll() {
        return authorRepository.findAllByIsDeletedFalse();
    }

    @Override
    public Optional getById(String id) {
        return authorRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return authorRepository.existsById(id);
    }

    @Override
    public Optional deleteById(String id) {
        Author author = authorRepository.findById(id).get();
        author.setIsDeleted(true);
        return Optional.ofNullable(authorRepository.save(author));
    }
}
