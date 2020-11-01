package app.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import app.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
