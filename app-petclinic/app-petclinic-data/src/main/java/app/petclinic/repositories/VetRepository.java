package app.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import app.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
