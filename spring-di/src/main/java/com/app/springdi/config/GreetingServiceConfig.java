package com.app.springdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.app.springdi.service.GreetingService;
import com.app.springdi.service.GreetingServiceFactory;

@Configuration
public class GreetingServiceConfig {
	@Bean
	GreetingServiceFactory greetingServiceFactory() {
		return new GreetingServiceFactory();
	}
	
	@Bean
	@Primary
	@Profile({"EN", "default"})
	GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("EN");
	}
	
	@Bean
	@Primary
	@Profile("ES")
	GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("ES");
	}
	
	@Bean
	@Primary
	@Profile("DE")
	GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("DE");
	}
}
