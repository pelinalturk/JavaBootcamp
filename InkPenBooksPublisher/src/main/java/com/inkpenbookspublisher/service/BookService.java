package com.inkpenbookspublisher.service;

import com.inkpenbookspublisher.model.dto.BookDto;
import com.inkpenbookspublisher.model.request.CreateBookRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookDto saveBook(CreateBookRequest createBookRequest);
    List<BookDto>getAllBooks();
    Optional<BookDto>getBookById(String id);
    void deleteBookById(String id);
    boolean existsByBookId(String id);
    Optional<List<BookDto>>getBooksByAuthorId(String authorId);
}
