package com.fdifrison.spring5.dependencyInjection.services;

import com.fdifrison.spring5.dependencyInjection.repositories.ItalianGreetingRepositoryImpl;

public class GreetingsServiceFactory {

    public I18nSpanishService getLanguage(String language) {
        switch (language) {
            case "SP":
                return new I18nSpanishService();
            default:
                return null;

        }
    }

}
