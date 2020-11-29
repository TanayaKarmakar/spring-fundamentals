package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.model.Address;

public interface AddressRepository extends MongoRepository<Address, String> {

}
