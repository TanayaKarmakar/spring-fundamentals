package com.app.recipe.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.app.recipe.domain.Recipe;

public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, Long> {

}
