package com.springboot.service;

import com.springboot.model.dto.BookDto;
import com.springboot.model.request.CreateBookRequest;
import com.springboot.model.request.UpdateBookRequest;

import java.util.List;

public interface BookService {
    BookDto createBook(CreateBookRequest createBookRequest);

    List<BookDto> getBooksByAuthorId(String authorId);

    List<BookDto> getAllBooks();
    void deleteBook(String id);

    BookDto updateNameOfAuthorByBook(String id, String name);

    BookDto updateNameAndReleaseDateOfBook(UpdateBookRequest updateBookRequest);
}
