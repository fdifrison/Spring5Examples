package com.fdifrison.spring5.dependencyInjection.controllers;

import com.fdifrison.spring5.dependencyInjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectionController {

    private GreetingService greetingService;
    @Qualifier("setterGreetingService")
    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void getGreeting() {
        System.out.println(greetingService.sayGreeting() + " from an injecting setter");
    }
}
