package com.app.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
