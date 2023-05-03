package com.inkpenbookspublisher.service;


import com.inkpenbookspublisher.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookEntityService {
    Book save(Book book);
    List<Book>findAll();
    void delete(String id);
    Optional<Book> getById(String id);
    boolean existsById(String id);
    Optional<List<Book>> getBookByAuthorId(String id);
}
