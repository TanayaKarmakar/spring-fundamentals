package app.petclinic.services;

import java.util.Set;

import app.petclinic.model.Pet;

public interface PetService {
	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
}
