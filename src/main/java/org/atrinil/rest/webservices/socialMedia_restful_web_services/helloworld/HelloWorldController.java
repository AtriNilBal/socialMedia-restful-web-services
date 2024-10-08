package org.atrinil.rest.webservices.socialMedia_restful_web_services.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//REST API
@RestController
public class HelloWorldController  {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // url - /hello-world
    //return String "Hello world"
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping("/hello-world/greet/{user}")
    public HelloWorldBean greetUser(@PathVariable String user) {
        return new HelloWorldBean(String.format("Hello %s", user));
    }
    @GetMapping("/hello-world-internationalized")
    public String HelloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message",
                locale);
    }

}
