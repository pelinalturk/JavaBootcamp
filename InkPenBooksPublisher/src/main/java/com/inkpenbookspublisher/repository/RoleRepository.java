package com.inkpenbookspublisher.repository;

import com.inkpenbookspublisher.model.Role;
import com.inkpenbookspublisher.model.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(Roles name);
}
