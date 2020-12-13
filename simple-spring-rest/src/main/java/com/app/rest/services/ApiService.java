package com.app.rest.services;

import java.util.List;

import com.app.rest.api.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {
	public List<User> getUsers(Integer limit);
	
	Flux<User> getUsers(Mono<Integer> limit);
}
