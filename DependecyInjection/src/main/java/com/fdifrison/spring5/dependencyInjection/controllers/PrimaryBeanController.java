package com.fdifrison.spring5.dependencyInjection.controllers;

import com.fdifrison.spring5.dependencyInjection.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class PrimaryBeanController {

    private final GreetingService greetingService;

    public PrimaryBeanController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void sayHello() {
        System.out.println(greetingService.sayGreeting() + " from Primary Bean");
    }
}
