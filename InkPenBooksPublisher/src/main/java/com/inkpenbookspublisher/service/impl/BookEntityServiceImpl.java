package com.inkpenbookspublisher.service.impl;

import com.inkpenbookspublisher.model.Book;
import com.inkpenbookspublisher.model.dto.BookDto;
import com.inkpenbookspublisher.repository.BookRepository;
import com.inkpenbookspublisher.service.BookEntityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookEntityServiceImpl implements BookEntityService {

    private final BookRepository bookRepository;

    public BookEntityServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> getById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return bookRepository.existsById(id);
    }

    @Override
    public Optional<List<Book>> getBookByAuthorId(String id) {
        return bookRepository.findByAuthorId(id);
    }
}
