package com.springboot.model.mapper;

import com.springboot.model.Book;
import com.springboot.model.dto.BookDto;
import com.springboot.model.request.CreateBookRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-02T18:56:31+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto convertToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto.BookDtoBuilder bookDto = BookDto.builder();

        bookDto.id( book.getId() );
        bookDto.name( book.getName() );
        bookDto.releaseYear( book.getReleaseYear() );
        bookDto.authorID( book.getAuthorID() );

        return bookDto.build();
    }

    @Override
    public Book createBook(CreateBookRequest createBookRequest) {
        if ( createBookRequest == null ) {
            return null;
        }

        Book.BookBuilder<?, ?> book = Book.builder();

        book.name( createBookRequest.getName() );
        book.releaseYear( createBookRequest.getReleaseYear() );
        book.authorID( createBookRequest.getAuthorID() );

        return book.build();
    }
}
