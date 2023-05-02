package com.springboot.service;

import com.springboot.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookEntityService {
    Book save(Book book);
    void deleteBook(String bookId);
    Optional<List<Book>> getBooksByAuthorId(String authorId);

    List<Book>getAllBooks();
    Optional getBookById(String bookId);
    Book updateNameAndReleaseDateOfBook(Book book);
}
