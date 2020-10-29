package app.petclinic.services.map;

import java.util.Set;

import app.petclinic.model.Specialty;
import app.petclinic.services.SpecialtiesService;

public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtiesService {

	@Override
	public Set<Specialty> findAll() {
		return super.findAll();
	}

	@Override
	public Specialty findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Specialty save(Specialty object) {
		return super.save(object);
	}

	@Override
	public void delete(Specialty object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}