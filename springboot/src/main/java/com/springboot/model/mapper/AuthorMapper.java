package com.springboot.model.mapper;

import com.springboot.model.Author;
import com.springboot.model.dto.AuthorDto;
import com.springboot.model.request.CreateAuthorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper AUTHOR_MAPPER = Mappers.getMapper(AuthorMapper.class);
    AuthorDto convertToAuthorDto(Author author);
    Author createAuthor(CreateAuthorRequest createAuthorRequest);
}
