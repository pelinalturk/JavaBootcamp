package com.inkpenbookspublisher.repository;

import com.inkpenbookspublisher.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
    List<Author>findAllByIsDeletedFalse();
}
