package com.app.rest.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.app.rest.domain.Vendor;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {

}
