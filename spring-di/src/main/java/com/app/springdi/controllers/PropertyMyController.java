package com.app.springdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.app.springdi.service.GreetingService;

@Controller
public class PropertyMyController {
	@Autowired
	@Qualifier("propertyGreetingService")
	GreetingService greetingService;
	
	public String sayHello() {
		return greetingService.sayHello();
	}
}
