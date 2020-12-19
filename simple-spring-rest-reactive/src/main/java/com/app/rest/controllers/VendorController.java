package com.app.rest.controllers;

import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@PostMapping("/api/v1/vendors")
	@ResponseStatus(HttpStatus.CREATED)
	Mono<Void> create(@RequestBody Publisher<Vendor> vendorStream) {
		return vendorRepository.saveAll(vendorStream).then();
	}
	
	@PutMapping("/api/v1/vendors/{id}")
	Mono<Vendor> update(@PathVariable String id, Vendor vendor) {
		vendor.setId(id);
		return vendorRepository.save(vendor);
	}
	
	
	@PatchMapping("/api/v1/vendors/{id}")
	Mono<Vendor> patch(@PathVariable String id, Vendor vendor) {
		Vendor foundVendor = vendorRepository.findById(id).block();
		
		if(!foundVendor.getFirstName().equals(vendor.getFirstName())) {
			foundVendor.setFirstName(vendor.getFirstName());
			
			return vendorRepository.save(foundVendor);
		}
		
		return Mono.just(foundVendor);
	}
}
