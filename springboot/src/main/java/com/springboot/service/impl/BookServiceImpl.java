package com.springboot.service.impl;

import com.springboot.model.Book;
import com.springboot.model.dto.BookDto;
import static com.springboot.model.mapper.BookMapper.BOOK_MAPPER;
import com.springboot.model.request.CreateBookRequest;
import com.springboot.model.request.UpdateBookRequest;
import com.springboot.service.AuthorEntityService;
import com.springboot.service.AuthorService;
import com.springboot.service.BookEntityService;
import com.springboot.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookEntityService bookEntityService;
    private final AuthorService authorService;

    public BookServiceImpl(BookEntityService bookEntityService, AuthorService authorService) {
        this.bookEntityService = bookEntityService;
        this.authorService = authorService;
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
        String authorId = book.get().getAuthorID();
        if(book.isPresent()){
            bookEntityService.deleteBook(id);
            List<Book> getBooksByAuthorID = bookEntityService.getBooksByAuthorId(authorId).get();
            if(getBooksByAuthorID.size() == 0){
                authorService.deleteAuthor(authorId);
            }
        }
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
