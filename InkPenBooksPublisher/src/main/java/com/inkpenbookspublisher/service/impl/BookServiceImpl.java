package com.inkpenbookspublisher.service.impl;

import com.inkpenbookspublisher.model.Book;
import com.inkpenbookspublisher.model.dto.BookDto;
import com.inkpenbookspublisher.model.request.CreateBookRequest;
import com.inkpenbookspublisher.service.BookEntityService;
import com.inkpenbookspublisher.service.BookService;
import static com.inkpenbookspublisher.model.mapper.BookMapper.BOOK_MAPPER;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookEntityService bookEntityService;

    public BookServiceImpl(BookEntityService bookEntityService) {
        this.bookEntityService = bookEntityService;
    }

    @Override
    public BookDto saveBook(CreateBookRequest createBookRequest) {
        Book book = BOOK_MAPPER.createBook(createBookRequest);
        bookEntityService.save(book);
        return BOOK_MAPPER.convertToBookDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookEntityService.findAll().stream().map(BOOK_MAPPER::convertToBookDto).collect(Collectors.toList());
    }
}
