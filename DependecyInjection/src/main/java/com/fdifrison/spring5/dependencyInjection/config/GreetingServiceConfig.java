package com.fdifrison.spring5.dependencyInjection.config;

import com.fdifrison.spring5.dependencyInjection.repositories.ItalianGreetingRepository;
import com.fdifrison.spring5.dependencyInjection.repositories.ItalianGreetingRepositoryImpl;
import com.fdifrison.spring5.dependencyInjection.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Profile({"SP", "default"})
    @Bean("i18nService") // bean name specified here
    I18nSpanishService i18nSpanishService(){
        return new I18nSpanishService();
    }

    @Bean
    ItalianGreetingRepository italianGreetingRepository() {
        return new ItalianGreetingRepositoryImpl();
    }

    @Profile("IT")
    @Bean
    I18nItalianService i18nService(ItalianGreetingRepository italianGreetingRepository){ //bean name as method name
        return new I18nItalianService(italianGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }
}
