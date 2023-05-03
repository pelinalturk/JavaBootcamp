package com.inkpenbookspublisher.model.mapper;

import com.inkpenbookspublisher.model.Book;
import com.inkpenbookspublisher.model.dto.BookDto;
import com.inkpenbookspublisher.model.request.CreateBookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    public static BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);

    BookDto convertToBookDto(Book book);
    Book createBook(CreateBookRequest createBookRequest);
}
