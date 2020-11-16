package com.app.recipe.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.commands.RecipeCommand;
import com.app.recipe.exceptions.NotFoundException;
import com.app.recipe.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RecipeController {
	private final RecipeService recipeService;
	
	private static final String RECIPE_RECIPEFORM_URL = "recipe/recipeform";

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping("/recipe/{id}/show")
	public String showById(@PathVariable("id") String id, Model model) {
		model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

		return "recipe/show";
	}

	@RequestMapping("/recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());

		return RECIPE_RECIPEFORM_URL;
	}
	
	@RequestMapping("/recipe/{id}/update")
	public String updateRecipe(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
		return RECIPE_RECIPEFORM_URL;
	}

	@PostMapping
	@RequestMapping("recipe")
	public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(error -> {
				log.debug(error.toString());
			});
			
			return RECIPE_RECIPEFORM_URL;
		}
		
		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
		return "redirect:" + savedCommand.getId() + "/show";
	}

	@GetMapping
	@RequestMapping("recipe/{id}/delete")
	public String deleteById(@PathVariable String id) {
		log.debug("deleting id : " + id);
		
		recipeService.deleteById(Long.valueOf(id));
		
		return "redirect:/";
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView handleNotFound(Exception ex) {
		log.error("Handling not found exception");
		log.error(ex.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.setViewName("404error");
		return mav;
	}
}
