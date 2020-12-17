package com.app.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.rest.domain.Vendor;
import com.app.rest.repositories.VendorRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VendorController {
	private VendorRepository vendorRepository;
	
	public VendorController(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}
	
	@GetMapping("/api/v1/vendors")
	Flux<Vendor> list() {
		return vendorRepository.findAll();
	}
	
	@GetMapping("/api/v1/vendors/{id}")
	Mono<Vendor> getById(@PathVariable String id) {
		return vendorRepository.findById(id);
	}

}
