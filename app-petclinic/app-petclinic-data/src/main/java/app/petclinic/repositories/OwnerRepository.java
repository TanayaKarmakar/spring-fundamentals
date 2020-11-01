package app.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import app.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
