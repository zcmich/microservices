package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

//@EnableWebMvc // for swagger
@SpringBootApplication
public class RestfulWebServicesApplication {
//A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.d
    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver(){
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

//    @Bean
//    public ResourceBundleMessageSource messageSource(){ //read values from the msg.properties
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//         messageSource.setBasename("messages");
//        return messageSource;
//    }

}
