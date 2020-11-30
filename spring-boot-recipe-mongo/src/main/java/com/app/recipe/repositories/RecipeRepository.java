package com.app.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.recipe.domain.Recipe;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
