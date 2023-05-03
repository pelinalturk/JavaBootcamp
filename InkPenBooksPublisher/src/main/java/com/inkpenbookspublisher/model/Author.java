package com.inkpenbookspublisher.model;

import com.inkpenbookspublisher.model.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document("authors")
public class Author extends BaseEntity{
    @Id
    private String id;
    private String name;
    private String email;
    private String biography;
    private List<Book>books= new ArrayList<>();
}
