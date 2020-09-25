package com.crizen.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.crizen.service.feign.FeignRemoteServiceA;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	FeignRemoteServiceA feignServiceA;
	

	@RequestMapping(path="/test", method=RequestMethod.GET)
	public String testMethod() {
        return "Service-B: 호출" + " > " + feignServiceA.testMethod();

	}
	
}
