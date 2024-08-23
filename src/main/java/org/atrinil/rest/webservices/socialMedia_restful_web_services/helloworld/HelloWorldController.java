package org.atrinil.rest.webservices.socialMedia_restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController  {

    // url - /hello-world
    //return String "Hello world"
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping(value = "/hello-world/greet/{user}")
    public HelloWorldBean greetUser(@PathVariable String user) {
        return new HelloWorldBean(String.format("Hello %s", user));
    }

}
