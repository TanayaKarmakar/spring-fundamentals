package app.petclinic.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import app.petclinic.model.Owner;
import app.petclinic.model.PetType;
import app.petclinic.services.OwnerService;
import app.petclinic.services.PetService;
import app.petclinic.services.PetTypeService;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
	private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
	
	private final PetService petService;
	private final OwnerService ownerService;
	private final PetTypeService petTypeService;
	
	public PetController(PetService petService, PetTypeService petTypeService, OwnerService ownerService) {
		this.petService = petService;
		this.ownerService = ownerService;
		this.petTypeService = petTypeService;
	}
	
	@ModelAttribute("types")
	public Collection<PetType> populatePetTypes() {
		return petTypeService.findAll();
	}

	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") long ownerId) {
		return ownerService.findById(ownerId);
	}

	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

}
