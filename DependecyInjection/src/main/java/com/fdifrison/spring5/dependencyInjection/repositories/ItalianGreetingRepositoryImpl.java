package com.fdifrison.spring5.dependencyInjection.repositories;

public class ItalianGreetingRepositoryImpl implements ItalianGreetingRepository {
    @Override
    public String getGreeting() {
        return "Ciao bello!";
    }
}
