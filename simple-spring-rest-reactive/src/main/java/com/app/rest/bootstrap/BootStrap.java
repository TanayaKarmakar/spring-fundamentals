package com.app.rest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.rest.domain.Category;
import com.app.rest.domain.Vendor;
import com.app.rest.repositories.CategoryRepository;
import com.app.rest.repositories.VendorRepository;

//@Component
public class BootStrap implements CommandLineRunner {
	private final CategoryRepository categoryRepository;
	private final VendorRepository vendorRepository;
	
	public BootStrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
		this.categoryRepository = categoryRepository;
		this.vendorRepository = vendorRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		if(categoryRepository.count().block() == 0) {
			//load data
			System.out.println("#### LOADING DATA ON BOOTSTRAP ####");
			categoryRepository.save(Category.builder()
					.description("Fruits").build()).block();
			
			categoryRepository.save(Category.builder()
					.description("Nuts").build()).block();
			
			categoryRepository.save(Category.builder()
					.description("Breads").build()).block();
			
			categoryRepository.save(Category.builder()
					.description("Meats").build()).block();
			
			categoryRepository.save(Category.builder()
					.description("Eggs").build()).block();
			
			System.out.println("Loaded categories");
			
			vendorRepository.save(Vendor.builder()
					.firstName("Joe")
					.lastName("Buck").build()).block();
			
			vendorRepository.save(Vendor.builder()
					.firstName("Michael")
					.lastName("Weston").build()).block();
			
			vendorRepository.save(Vendor.builder()
					.firstName("Jessie")
					.lastName("Waters").build()).block();
			
			vendorRepository.save(Vendor.builder()
					.firstName("Bill")
					.lastName("Nershi").build()).block();
			
			vendorRepository.save(Vendor.builder()
					.firstName("Jimmy")
					.lastName("Buffett").build()).block();
			
			System.out.println("Loaded Vendors: " + vendorRepository.count().block());
			
		
		}
		
	}

}
