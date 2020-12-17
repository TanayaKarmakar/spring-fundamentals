package com.app.rest.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.app.rest.domain.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {

}
