package com.app.service;

import java.util.List;

import com.app.model.User;

public interface UserService {
	
	public List<User> getAll();
	
	public User findUserById(String id);
	
	public User createUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(String id);

}
