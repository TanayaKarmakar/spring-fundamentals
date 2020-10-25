package com.app.springdi.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Service
//@Profile("DE")
public class I18nGermanGreetingService implements GreetingService {

	@Override
	public String sayHello() {
		return "Hallo Welt - DE";
	}

}
