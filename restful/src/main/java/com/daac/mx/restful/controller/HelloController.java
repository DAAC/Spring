package com.daac.mx.restful.controller;

import com.daac.mx.restful.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/helloworld")
    public String getMessage(){
        return "Hello Dante";
    }

    @GetMapping(path = "/helloworldbean")
    public HelloWorldBean getMessageBean(){
        return new HelloWorldBean("Hello Dante");
    }
}
