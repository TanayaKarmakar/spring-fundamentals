package com.app.springdi.service;

import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingService implements GreetingService {

	@Override
	public String sayHello() {
		return "Property: Hello Folks";
	}

}
