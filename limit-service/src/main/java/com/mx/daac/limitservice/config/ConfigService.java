package com.mx.daac.limitservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class ConfigService {

    @Value("${limits-service.minimum}")
    private int minimum;
    @Value("${limits-service.maximum}")
    private int maximum;
}
