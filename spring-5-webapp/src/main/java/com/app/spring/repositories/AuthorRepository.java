package com.app.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.spring.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
