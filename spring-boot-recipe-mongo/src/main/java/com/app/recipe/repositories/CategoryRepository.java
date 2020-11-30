package com.app.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.recipe.domain.Category;

/**
 * Created by jt on 6/13/17.
 */
public interface CategoryRepository extends CrudRepository<Category, String> {

    Optional<Category> findByDescription(String description);
}
