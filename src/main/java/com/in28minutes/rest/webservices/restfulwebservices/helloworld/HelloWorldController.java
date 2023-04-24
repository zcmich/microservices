package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;
    @GetMapping(path = "/helloWorld")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping(path = "/hello-world-bean" )
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Cliff");
    }

    @GetMapping(path = "hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world, %s",name));
    }

    @GetMapping(path = "/hello-world-internationalization" )
    public HelloWorldBean helloWorldInternationalization(){
        String gm_message = messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
        return new HelloWorldBean(gm_message + " Cliff");

    }



}
