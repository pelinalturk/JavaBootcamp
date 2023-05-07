package com.inkpenbookspublisher.model.mapper;

import com.inkpenbookspublisher.model.Author;
import com.inkpenbookspublisher.model.dto.AuthorDto;
import com.inkpenbookspublisher.model.dto.AuthorWithBookDto;
import com.inkpenbookspublisher.model.request.CreateAuthorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper AUTHOR_MAPPER = Mappers.getMapper(AuthorMapper.class);

    AuthorDto convertToAuthorDto(Author author);
    Author createAuthor(CreateAuthorRequest createAuthorRequest);

    @Mapping(source = "books", target = "books")
    AuthorWithBookDto convertToAuthorWithBookDto(Author author);
}
