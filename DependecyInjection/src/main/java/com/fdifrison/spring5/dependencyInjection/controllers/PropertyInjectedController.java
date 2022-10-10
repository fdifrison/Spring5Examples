package com.fdifrison.spring5.dependencyInjection.controllers;

import com.fdifrison.spring5.dependencyInjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    // needs to be public otherwise it cant be injected.. hence don't use property injection!
    @Qualifier("propertyGreetingService")
    @Autowired /*
     we need autowire to tell spring to inject an instance of Greeting service otherwise we will get a NullpointerException
     Also spring says : Fields injection is not recommended
    */
    public GreetingService greetingService;
    public void getGreeting() {
        System.out.println(greetingService.sayGreeting() + " from an injecting property");
    }
}
