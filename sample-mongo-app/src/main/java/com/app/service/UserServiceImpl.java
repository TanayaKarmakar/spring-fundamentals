package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.model.Address;
import com.app.model.User;
import com.app.repository.AddressRepository;
import com.app.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;
	
	public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(String id) {
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isPresent())
			return userOptional.get();
		throw new RuntimeException("User Not Found");
	}

	@Override
	public User createUser(User user) {
		Address savedAddress = addressRepository.save(user.getAddress());
		user.setAddress(savedAddress);
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public User updateUser(User user) {
		//fetch the address
		Address address = user.getAddress();
		//if it is a new one 
		User updatedUser = null;
		if(address.getId() == null) {
			address = addressRepository.save(address);
			user.setAddress(address);
			updatedUser = userRepository.save(user);
		} else {
			Optional<User> savedUserOptional = userRepository.findById(user.getId());
			if(savedUserOptional.isPresent()) {
				User savedUser = savedUserOptional.get();
				Address savedAddress = savedUser.getAddress();
				if(!savedAddress.equals(address)) {
					address = addressRepository.save(address);
					user.setAddress(address);
				}
				updatedUser = userRepository.save(user);
			} else {
				throw new RuntimeException("User not found");
			}	
		}
		return Optional.ofNullable(updatedUser).orElseGet(() -> new User()) ;
	}

	@Override
	public void deleteUser(String id) {
		try {
			userRepository.deleteById(id);
		} catch(RuntimeException ex) {
			log.debug("Error ", ex);
			throw new RuntimeException("An Error occurred while trying to delete the user");
		}
	}
}
