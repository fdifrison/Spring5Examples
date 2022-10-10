package com.fdifrison.spring5.dependencyInjection;

import com.fdifrison.spring5.dependencyInjection.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);

		System.out.println("------- Primary Bean Injection ---------");
		// The myController instance is injected by spring, we do not need to initialize it
		PrimaryBeanController myController = (PrimaryBeanController) ctx.getBean("primaryBeanController");
		myController.sayHello();

		System.out.println("------- Property Injection ---------");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		propertyInjectedController.getGreeting();

		System.out.println("------- Setter Injection ---------");
		SetterInjectionController setterInjectionController = (SetterInjectionController) ctx.getBean("setterInjectionController") ;
		setterInjectionController.getGreeting();

		System.out.println("------- Constructor Injection ---------");
		ConstructorInjectionController constructorInjectionController = (ConstructorInjectionController) ctx.getBean("constructorInjectionController");
		constructorInjectionController.getGreeting();


		System.out.println("------- Profile in Action ---------");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		i18nController.speakBaseOnProfile();

	}

}
