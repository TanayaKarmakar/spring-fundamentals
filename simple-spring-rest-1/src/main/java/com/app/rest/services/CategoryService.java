package com.app.rest.services;

import java.util.List;

import com.app.rest.api.v1.model.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> getAllCategories();
	
	CategoryDTO getCategoryByName(String name);
}
