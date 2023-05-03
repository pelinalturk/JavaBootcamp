package com.inkpenbookspublisher.repository;

import com.inkpenbookspublisher.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Optional<List<Book>>findByAuthorId(String authorId);
}
