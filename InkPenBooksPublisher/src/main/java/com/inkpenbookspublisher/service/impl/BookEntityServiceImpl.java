package com.inkpenbookspublisher.service.impl;

import com.inkpenbookspublisher.model.Book;
import com.inkpenbookspublisher.model.dto.BookDto;
import com.inkpenbookspublisher.repository.BookRepository;
import com.inkpenbookspublisher.service.BookEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
