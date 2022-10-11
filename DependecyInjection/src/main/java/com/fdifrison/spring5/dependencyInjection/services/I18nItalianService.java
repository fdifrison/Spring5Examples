package com.fdifrison.spring5.dependencyInjection.services;

import com.fdifrison.spring5.dependencyInjection.repositories.ItalianGreetingRepository;
import com.fdifrison.spring5.dependencyInjection.repositories.ItalianGreetingRepositoryImpl;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class I18nItalianService implements  GreetingService{

    private final ItalianGreetingRepository italianGreetingRepository;

    public I18nItalianService(ItalianGreetingRepository italianGreetingRepository) {
        this.italianGreetingRepository = italianGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Ciao bello!";
    }
}
