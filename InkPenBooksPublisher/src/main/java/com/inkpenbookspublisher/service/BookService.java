package com.inkpenbookspublisher.service;

import com.inkpenbookspublisher.model.dto.BookDto;
import com.inkpenbookspublisher.model.request.CreateBookRequest;

import java.util.List;

public interface BookService {
    BookDto saveBook(CreateBookRequest createBookRequest);
    List<BookDto>getAllBooks();
}
