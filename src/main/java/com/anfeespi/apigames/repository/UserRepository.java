package com.anfeespi.apigames.repository;

import com.anfeespi.apigames.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
