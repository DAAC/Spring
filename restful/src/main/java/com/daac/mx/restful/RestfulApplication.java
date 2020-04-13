package com.daac.mx.restful;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class RestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}

}
