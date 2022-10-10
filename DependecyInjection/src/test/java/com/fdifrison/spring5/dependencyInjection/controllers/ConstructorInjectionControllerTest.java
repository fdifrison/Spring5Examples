package com.fdifrison.spring5.dependencyInjection.controllers;

import com.fdifrison.spring5.dependencyInjection.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectionControllerTest {

    ConstructorInjectionController controller;

    @BeforeEach
    void setUp() {
        //Mimic what the spring framework would do to instantiate a controller object
        controller = new ConstructorInjectionController(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        controller.getGreeting();
    }
}