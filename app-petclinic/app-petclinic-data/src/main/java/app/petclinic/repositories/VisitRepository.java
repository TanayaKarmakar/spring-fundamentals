package app.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import app.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
