package com.app.recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.recipe.domain.UnitOfMeasure;

/**
 * Created by jt on 6/13/17.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, String> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
