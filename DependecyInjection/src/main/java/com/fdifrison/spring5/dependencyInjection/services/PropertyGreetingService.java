package com.fdifrison.spring5.dependencyInjection.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public class PropertyGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World";
    }
}
