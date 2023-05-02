package com.springboot.model.mapper;

import com.springboot.model.Author;
import com.springboot.model.dto.AuthorDto;
import com.springboot.model.request.CreateAuthorRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-02T18:56:31+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDto convertToAuthorDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto.AuthorDtoBuilder authorDto = AuthorDto.builder();

        authorDto.id( author.getId() );
        authorDto.name( author.getName() );

        return authorDto.build();
    }

    @Override
    public Author createAuthor(CreateAuthorRequest createAuthorRequest) {
        if ( createAuthorRequest == null ) {
            return null;
        }

        Author.AuthorBuilder<?, ?> author = Author.builder();

        author.name( createAuthorRequest.getName() );

        return author.build();
    }
}
