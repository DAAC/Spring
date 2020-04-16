package com.daac.mx.restful;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class RestfulApplicationTests {


	void contextLoads() {
		List<String> names = new ArrayList<>();
		names.add("John");
		names.add("Ana");
		names.add("Mary");
		names.add("Anthony");
		names.add("Mark");

		names.stream()
				.filter(name -> !name.equals("Ana"))
				.collect(Collectors.toList())
				.forEach(System.out::println);

	}


}
