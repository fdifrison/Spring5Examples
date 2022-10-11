package com.fdifrison.spring5.dependencyInjection.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class I18nItalianService implements  GreetingService{
    @Override
    public String sayGreeting() {
        return "Ciao bello!";
    }
}
