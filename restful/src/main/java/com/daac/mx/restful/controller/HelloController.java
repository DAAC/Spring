package com.daac.mx.restful.controller;

import com.daac.mx.restful.bean.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/helloworld")
    public String getMessage() {
        return "Hello Dante";
    }

    @GetMapping(path = "/helloworldbean")
    public HelloWorldBean getMessageBean() {
        return new HelloWorldBean("Hello Dante");
    }

    @GetMapping(path = "/helloworldbean/pathvariable/{name}")
    public HelloWorldBean getMessagePathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello, %s", name));
    }

    @GetMapping(path = "/helloworldinternationalized")
    public String helloworldinternationalized(@RequestHeader(name = "Accept-Langauge", required = false) Locale locale){
        return messageSource.getMessage("good.morning.message", null, locale);
    }
}