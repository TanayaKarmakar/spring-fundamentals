package com.app.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.rest.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String name);
}
