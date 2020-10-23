package com.app.springdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.app.springdi.controllers.I18nController;
import com.app.springdi.controllers.MyController;
import com.app.springdi.controllers.PropertyMyController;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);
	
		I18nController i18Controller = (I18nController)ctx.getBean("i18nController");
		
		System.out.println(i18Controller.sayHello());
		
		MyController myController = (MyController)ctx.getBean("myController");
		
		String greeting = myController.sayHello();
		
		System.out.println(greeting);
		
		System.out.println("Property ---------- ");
		
		PropertyMyController pMyController = (PropertyMyController)ctx.getBean("propertyMyController");
		
		System.out.println(pMyController.sayHello());
	}

}
