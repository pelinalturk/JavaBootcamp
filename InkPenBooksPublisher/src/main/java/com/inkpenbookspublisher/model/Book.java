package com.inkpenbookspublisher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Document("books")
public class Book extends BaseEntity{
    @Id
    private String id;
    private String name;
    private String releaseYear;
    private String authorId;
}