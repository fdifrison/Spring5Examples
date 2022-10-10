package com.fdifrison.spring5.dependencyInjection.controllers;

import com.fdifrison.spring5.dependencyInjection.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectionControllerTest {

    SetterInjectionController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectionController();
        // initialize the service through a setter method
        controller.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        controller.getGreeting();
    }
}