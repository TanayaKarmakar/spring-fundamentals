package com.app.recipe.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.app.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure, String> {

}
