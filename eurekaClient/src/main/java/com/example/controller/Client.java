package com.example.controller;

import com.example.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Client {

	private static Logger logger = LoggerFactory.getLogger(Client.class);

	@Value("${server.port}")
	String port;

	@Value("${test.params:侯小碧}")
	String params;

	@RequestMapping("/hello")
	public String home(@RequestParam String name) {
		return "Hello, " + name + " , call successfully, service on port : " + port;
	}

	@RequestMapping("/helloBody")
	public String helloBody(@RequestBody User user) {
		logger.info("client");
		return "HelloBody, " + user.getName() + " , call successfully, service on port : " + port;
	}

	@RequestMapping("/params")
	public String params() {
		return "Hello, " + params ;
	}

}
