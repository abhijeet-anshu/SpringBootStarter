package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beans.LimitConfiguration;
import com.config.MyConfiguration;

@RestController
public class MyController {
	@GetMapping("/messages")
	public String getMessage() {
		return "Welcome to MicroService";
	}
	
	@Autowired
	MyConfiguration config;
	
	@GetMapping("/limits-dummy-config")
	public LimitConfiguration getConfigDummy() {
		return new LimitConfiguration(12,200);
	}
	
	@GetMapping("/limits-config")
	public LimitConfiguration getConfig() {
		return new LimitConfiguration(config.getMinimum(), config.getMaximum());
	}
	
	@GetMapping("/limits-dynamic")
	public LimitConfiguration getConfigDynamic() {
		return new LimitConfiguration(config.getMinimum(), config.getMaximum());
	}
}
