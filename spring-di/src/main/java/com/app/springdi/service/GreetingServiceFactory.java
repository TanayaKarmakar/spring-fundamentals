package com.app.springdi.service;

public class GreetingServiceFactory {
	public GreetingService createGreetingService(String lang) {
		switch (lang) {
			case "EN":
				return new I18nEnglishGreetingService();
			case "ES":
				return new I18nSpanishGreetingService();
			case "DE":
				return new I18nGermanGreetingService();
			default:
				return new GreetingServiceImpl();

		}
	}
}
