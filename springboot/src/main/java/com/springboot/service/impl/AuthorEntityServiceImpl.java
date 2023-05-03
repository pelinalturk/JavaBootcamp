package com.springboot.service.impl;

import com.springboot.model.Author;
import com.springboot.repository.AuthorRepository;
import com.springboot.service.AuthorEntityService;
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
    public List<Author> getAllActiveAuthors() {
        return authorRepository.findAllByIsDeletedFalse().get();
    }

    @Override
    public void deleteAuthor(String authorID) {
        Author author = authorRepository.findById(authorID).get();
        author.setIsDeleted(true);
        authorRepository.save(author);
    }

    @Override
    public Optional getAuthorById(String authorId) {
        return authorRepository.findById(authorId);
    }
}
