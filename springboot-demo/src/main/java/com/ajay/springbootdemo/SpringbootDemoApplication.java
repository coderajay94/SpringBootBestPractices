package com.ajay.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})

public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
