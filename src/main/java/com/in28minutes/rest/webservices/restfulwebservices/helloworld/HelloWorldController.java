package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

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
        return new HelloWorldBean("Good morning");
    }


}
