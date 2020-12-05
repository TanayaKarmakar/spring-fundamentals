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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "This is the User Controller")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@ApiOperation(value = "This will get the list of all users", notes = "get All Users")
	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		return userService.getAll();
	}
	
	@ApiOperation(value = "This will get information of a particular user", notes = "get user by user id")
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable String id) {
		return userService.findUserById(id);
	}
	
	@ApiOperation(value = "This method will create a new user", notes = "new user")
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@ApiOperation(value = "This method will update a single user", notes = "Update user")
	@PostMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@ApiOperation(value = "This method will delete an existing user", notes = "Delete User")
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return id;
	}
}
