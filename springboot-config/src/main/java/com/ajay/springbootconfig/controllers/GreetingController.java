package com.ajay.springbootconfig.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.springbootconfig.configproperties.DbConfig;

@RestController
public class GreetingController {

	@Autowired
	Environment environment;

	@Value("${my.greeting}")
	String greeting;

	@Value("${app.description}")
	String appDescription;

	// default value when prop not there in property file, other app will fail to
	// inject the depenency
	/*
	 * @Value("${user.name : default value}") private String userName;
	 */

	@Value("${my.list.names}")
	private List<String> names;

	/*
	 * @Value("#{${dbvalues}}") private Map<String, String> dbValues;
	 */

	@Autowired
	DbConfig prop;

	@GetMapping("/greet")
	public String sayGreeting() {
		// return "welcome!!! " + greeting+" to "+appDescription+ "user: "+userName+"
		// list of names:"+names +"db values:"+dbValues;
		return "hello : " + prop.getConnection() + " " + prop.getHost() + " " + prop.getPort();
	}

	@GetMapping("/env")
	public String getEnvironmentDetails() {
		//not recommended to use get property
		return environment.getProperty("my.greeting")+" "+environment.toString();
	}
}
