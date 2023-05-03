package com.inkpenbookspublisher.model.dto;

import com.inkpenbookspublisher.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorWithBookDto {
    private String id;
    private String name;
    private List<BookDto>books = new ArrayList<>();
}
