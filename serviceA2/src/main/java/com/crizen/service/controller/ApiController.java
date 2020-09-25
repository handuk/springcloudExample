package com.crizen.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@RequestMapping(path="/test", method=RequestMethod.GET)
	public String testMethod() {
		return "ServiceA : 8011";
	}
	
}
