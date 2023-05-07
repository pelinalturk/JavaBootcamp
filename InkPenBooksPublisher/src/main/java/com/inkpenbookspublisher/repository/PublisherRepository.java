package com.inkpenbookspublisher.repository;

import com.inkpenbookspublisher.model.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends MongoRepository<Publisher, String> {
    Optional<Publisher> findByEmail(String email);
    Boolean existsByEmail(String username);

}
