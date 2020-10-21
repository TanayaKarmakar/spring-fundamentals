package com.app.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.spring.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
