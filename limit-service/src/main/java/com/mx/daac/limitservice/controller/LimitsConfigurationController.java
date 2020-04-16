package com.mx.daac.limitservice.controller;

import com.mx.daac.limitservice.bean.LimitConfiguration;
import com.mx.daac.limitservice.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private ConfigService configService;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration(){
        return new LimitConfiguration(configService.getMaximum(), configService.getMinimum());
    }
}
