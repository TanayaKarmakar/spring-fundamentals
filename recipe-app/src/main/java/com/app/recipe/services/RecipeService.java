package com.app.recipe.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.app.recipe.domain.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipes();
	
	Recipe findById(Long id);
}
