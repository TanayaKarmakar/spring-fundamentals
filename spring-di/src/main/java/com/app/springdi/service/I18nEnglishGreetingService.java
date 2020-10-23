package com.app.springdi.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("i18nService")
@Profile("EN")
public class I18nEnglishGreetingService implements GreetingService {

	@Override
	public String sayHello() {
		return "Hello World - EN";
	}

}
