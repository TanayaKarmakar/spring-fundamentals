package app.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import app.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
