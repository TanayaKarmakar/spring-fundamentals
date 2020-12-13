package com.app.rest.services;

import java.util.List;

import com.app.rest.api.domain.User;

public interface ApiService {
	public List<User> getUsers(Integer limit);
}
