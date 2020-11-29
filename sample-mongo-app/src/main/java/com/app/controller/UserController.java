package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		return userService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable String id) {
		return userService.findUserById(id);
	}
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PostMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return id;
	}
}
