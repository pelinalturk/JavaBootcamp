package com.inkpenbookspublisher.service.impl;

import com.inkpenbookspublisher.exception.AuthorNotFoundException;
import com.inkpenbookspublisher.exception.BookNotFoundException;
import com.inkpenbookspublisher.model.Book;
import com.inkpenbookspublisher.model.dto.BookDto;
import com.inkpenbookspublisher.model.request.CreateBookRequest;
import com.inkpenbookspublisher.service.AuthorService;
import com.inkpenbookspublisher.service.BookEntityService;
import com.inkpenbookspublisher.service.BookService;
import static com.inkpenbookspublisher.model.mapper.BookMapper.BOOK_MAPPER;
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
    public BookDto saveBook(CreateBookRequest createBookRequest) {
        Book book = BOOK_MAPPER.createBook(createBookRequest);
        if(authorService.existsByAuthorId(book.getAuthorId())){
            bookEntityService.save(book);
            return BOOK_MAPPER.convertToBookDto(book);
        }
        throw new AuthorNotFoundException("Author not found by id: " + createBookRequest.getAuthorId());
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookEntityService.findAll().stream().map(BOOK_MAPPER::convertToBookDto).collect(Collectors.toList());
    }

    @Override
    public Optional<BookDto> getBookById(String id) {
        Optional<Book> book = bookEntityService.getById(id);
        if (book.isPresent()) {
            return Optional.ofNullable(BOOK_MAPPER.convertToBookDto(book.get()));
        }
        return Optional.ofNullable(BOOK_MAPPER.convertToBookDto(book.orElseThrow(
                () -> new BookNotFoundException("Book not found by id: " + id))));
    }

    @Override
    public void deleteBookById(String id) {
        Optional<Book>book = bookEntityService.getById(id);
        String authorId = book.get().getAuthorId();
        if (book.isPresent()) {
            bookEntityService.delete(id);
            Optional<List<Book>>getBookByAuthorId = bookEntityService.getBookByAuthorId(authorId);
            if(getBookByAuthorId.get().size()==0){
                authorService.deleteAuthorById(authorId);
            }
        }
        else {
            throw new BookNotFoundException("Book not found by id: " + authorId);
        }
    }

    @Override
    public boolean existsByBookId(String id) {
        return bookEntityService.existsById(id);
    }

    @Override
    public Optional<List<BookDto>> getBooksByAuthorId(String authorId) {
        Optional<List<Book>> bookList = bookEntityService.getBookByAuthorId(authorId);
        if (authorService.existsByAuthorId(authorId)) {
            if (bookList.isPresent()) {
                return Optional.ofNullable(bookList.get().stream().map(BOOK_MAPPER::convertToBookDto).collect(Collectors.toList()));
            }
        }
        throw new AuthorNotFoundException("Author not found by id: " + authorId);
    }
}
