package com.springboot.repository;

import com.springboot.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findByAuthorID(String authorId);
    Optional<List<Book>> findAllByIsDeletedFalse();
    void deleteBookById(String id);
    Optional<List<Book>>findAllByAuthorID(String authorID);
}
