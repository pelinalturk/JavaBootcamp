package com.springboot.service.impl;

import com.springboot.model.Book;
import com.springboot.model.dto.BookDto;
import static com.springboot.model.mapper.BookMapper.BOOK_MAPPER;
import com.springboot.model.request.CreateBookRequest;
import com.springboot.model.request.UpdateBookRequest;
import com.springboot.service.BookEntityService;
import com.springboot.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookEntityService bookEntityService;

    public BookServiceImpl(BookEntityService bookEntityService) {
        this.bookEntityService = bookEntityService;
    }

    @Override
    public BookDto createBook(CreateBookRequest createBookRequest) {
        Book book = BOOK_MAPPER.createBook(createBookRequest);
        book = bookEntityService.save(book);
        return BOOK_MAPPER.convertToBookDto(book);
    }

    @Override
    public List<BookDto> getBooksByAuthorId(String authorId) {
        List<Book> books = bookEntityService.getBooksByAuthorId(authorId).get();
        return books.stream().map(BOOK_MAPPER::convertToBookDto).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookEntityService.getAllBooks();
        return books.stream().map(BOOK_MAPPER::convertToBookDto).collect(Collectors.toList());
    }

    @Override
    public void deleteBook(String id) {
        Optional<Book> book = bookEntityService.getBookById(id);
        if(book.isPresent()){
            Optional<List<Book>>getBooksByAuthorID = bookEntityService.getBooksByAuthorId(book.get().getAuthorID());
            if(!getBooksByAuthorID.isPresent()){}
                //soft delete will be applied
        }
            bookEntityService.deleteBook(id);
    }

    @Override
    public BookDto updateNameOfAuthorByBook(String id, String name) {
        Optional<Book> book = bookEntityService.getBookById(id);
        if(book.isPresent())
        {
            book.get().setName(name);
            bookEntityService.save(book.get());
        }
        return BOOK_MAPPER.convertToBookDto(book.get());
    }

    @Override
    public BookDto updateNameAndReleaseDateOfBook(UpdateBookRequest updateBookRequest) {
        Optional<Book> book = bookEntityService.getBookById(updateBookRequest.getId());
        if(book.isPresent()){
            book.get().setName(updateBookRequest.getName());
            book.get().setReleaseYear(updateBookRequest.getReleaseYear());
            bookEntityService.updateNameAndReleaseDateOfBook(book.get());
        }
        return BOOK_MAPPER.convertToBookDto(book.get());
    }
}
