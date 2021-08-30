package com.ajay.springcloudconfigserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@Value("${my.greeting:defaultvalue}")
	String greeting;

	@Autowired
	Environment env;

	@GetMapping("/greet")
	public String sayGreeting() {

		return "hello : " + greeting;
	}

}
