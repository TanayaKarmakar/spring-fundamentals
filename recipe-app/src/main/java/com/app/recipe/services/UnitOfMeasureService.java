package com.app.recipe.services;

import java.util.Set;

import com.app.recipe.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {
	Set<UnitOfMeasureCommand> listAllUoms();

}
