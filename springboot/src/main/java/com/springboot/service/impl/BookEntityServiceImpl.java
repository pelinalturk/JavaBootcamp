package com.springboot.service.impl;

import com.springboot.model.Book;
import com.springboot.repository.BookRepository;
import com.springboot.service.BookEntityService;
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
    public void deleteBook(String bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Optional<List<Book>> getBooksByAuthorId(String authorId) {
        return bookRepository.findAllByAuthorID(authorId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Book updateNameAndReleaseDateOfBook(Book book) {
        return bookRepository.save(book);
    }
}
