package com.inkpenbookspublisher.service.impl;

import com.inkpenbookspublisher.exception.AuthorNotFoundException;
import com.inkpenbookspublisher.model.Author;
import com.inkpenbookspublisher.model.dto.AuthorDto;
import static com.inkpenbookspublisher.model.mapper.AuthorMapper.AUTHOR_MAPPER;
import static com.inkpenbookspublisher.model.mapper.BookMapper.BOOK_MAPPER;

import com.inkpenbookspublisher.model.dto.AuthorWithBookDto;
import com.inkpenbookspublisher.model.dto.BookDto;
import com.inkpenbookspublisher.model.request.CreateAuthorRequest;
import com.inkpenbookspublisher.service.AuthorEntityService;
import com.inkpenbookspublisher.service.AuthorService;
import com.inkpenbookspublisher.service.BookEntityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorEntityService authorEntityService;
    private final BookEntityService bookEntityService;

    public AuthorServiceImpl(AuthorEntityService authorEntityService, BookEntityService bookEntityService) {
        this.authorEntityService = authorEntityService;
        this.bookEntityService = bookEntityService;
    }

    @Override
    public AuthorDto saveAuthor(CreateAuthorRequest createAuthorRequest) {
        Author author = AUTHOR_MAPPER.createAuthor(createAuthorRequest);
        authorEntityService.save(author);
        return AUTHOR_MAPPER.convertToAuthorDto(author);
    }

    @Override
    public Optional<List<AuthorDto>> getAllAuthors() {
        return Optional.ofNullable(authorEntityService.getAll().get().stream()
                .map(AUTHOR_MAPPER::convertToAuthorDto).collect(Collectors.toList()));
    }

    @Override
    public Optional<AuthorDto> getAuthorById(String id) {
        Optional<Author> author = authorEntityService.getById(id);
        if (author.isPresent()) {
            return Optional.ofNullable(AUTHOR_MAPPER.convertToAuthorDto(author.get()));
        }
        return Optional.ofNullable(AUTHOR_MAPPER.convertToAuthorDto(author.orElseThrow(() -> new AuthorNotFoundException("Author not found by id: " + id))));
    }

    @Override
    public boolean existsByAuthorId(String id) {
        return authorEntityService.existsById(id);
    }

    @Override
    public Optional deleteAuthorById(String id) {
        Optional<Author> author = authorEntityService.getById(id);
        return author.isPresent() ? authorEntityService.deleteById(id) : Optional.ofNullable(author.orElseThrow(() -> new AuthorNotFoundException("Author not found by id: " + id)));
    }

    @Override
    public List<AuthorWithBookDto> getAllBooksWithAuthor() {
        Optional<List<Author>> authors = authorEntityService.getAll();
        List<AuthorWithBookDto> authorWithBookDtos = new ArrayList<>();

        for (Author getAuthor : authors.get()) {
            AuthorWithBookDto authorWithBookDto = AUTHOR_MAPPER.convertToAuthorWithBookDto(getAuthor);
            authorWithBookDto.setBooks(bookEntityService.getBookByAuthorId
                    (getAuthor.getId()).get().stream().map(BOOK_MAPPER::convertToBookDto).collect(Collectors.toList()));
            authorWithBookDtos.add(authorWithBookDto);

        }
        return authorWithBookDtos;
    }

    @Override
    public Optional<AuthorWithBookDto> getBooksWithAuthor(String authorId) {
            Optional<Author> author = authorEntityService.getById(authorId);
            if (author.isPresent()) {
                List<BookDto> books = bookEntityService.getBookByAuthorId(authorId).get()
                        .stream()
                        .map(book -> BOOK_MAPPER.convertToBookDto(book))
                        .collect(Collectors.toList());

                AuthorWithBookDto authorWithBookDto = AUTHOR_MAPPER.convertToAuthorWithBookDto(author.get());
                authorWithBookDto.setBooks(books);
                return Optional.of(authorWithBookDto);
            }
            throw new AuthorNotFoundException("Author not found by id: " + authorId);
    }
}
