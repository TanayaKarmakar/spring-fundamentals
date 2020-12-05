package com.app.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.app.model.Address;
import com.app.model.User;
import com.app.repository.AddressRepository;
import com.app.repository.UserRepository;

//@Component
public class MongoBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;
	
	public MongoBootstrap(UserRepository userRepository, AddressRepository addressRepository) {
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
	}
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Address address = new Address();
		address.setAddressLine("123, Main Street");
		address.setCity("Chicago");
		address.setState("IL");
		address.setZipCode("56780");
		addressRepository.save(address);
		
		User user = new User();
		user.setFirstName("Martin");
		user.setLastName("Kleppman");
		user.setAddress(address);
		
		userRepository.save(user);
		
	}

}
