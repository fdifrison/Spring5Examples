package com.fdifrison.spring5.dependencyInjection.config;

import com.fdifrison.spring5.dependencyInjection.datasource.FakeDataSource;
import com.fdifrison.spring5.dependencyInjection.repositories.ItalianGreetingRepository;
import com.fdifrison.spring5.dependencyInjection.repositories.ItalianGreetingRepositoryImpl;
import com.fdifrison.spring5.dependencyInjection.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${fdifrison.password}") String password,
                                  @Value("${fdifrison.username}") String username,
                                  @Value("${fdifrison.url}") String url) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setPassword(password);
        fakeDataSource.setUsername(username);
        fakeDataSource.setUrl(url);
         return  fakeDataSource;
    }

    @Bean
    GreetingsServiceFactory greetingsServiceFactory() {
        return new GreetingsServiceFactory();
    }

    @Profile({"SP", "default"})
    @Bean("i18nService")
        // bean name specified here
    I18nSpanishService i18nSpanishService(GreetingsServiceFactory greetingsServiceFactory) {
        return greetingsServiceFactory.getLanguage("SP");
    }

    @Bean
    ItalianGreetingRepository italianGreetingRepository() {
        return new ItalianGreetingRepositoryImpl();
    }

    @Profile("IT")
    @Bean("i18nService")
    I18nItalianService i18nItalianService(ItalianGreetingRepository italianGreetingRepository) { //bean name as method name
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
