package com.app.recipe.services;

import com.app.recipe.commands.UnitOfMeasureCommand;

import reactor.core.publisher.Flux;

/**
 * Created by jt on 6/28/17.
 */
public interface UnitOfMeasureService {

    Flux<UnitOfMeasureCommand> listAllUoms();
}
