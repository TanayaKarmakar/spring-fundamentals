package app.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import app.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

}
