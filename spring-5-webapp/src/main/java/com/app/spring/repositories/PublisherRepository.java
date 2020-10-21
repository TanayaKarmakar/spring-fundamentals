package com.app.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.spring.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
