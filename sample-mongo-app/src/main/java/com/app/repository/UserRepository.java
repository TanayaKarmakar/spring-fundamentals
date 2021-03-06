package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
