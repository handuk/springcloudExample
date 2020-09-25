package com.crizen.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.crizen.service.feign.FeignRemoteServiceA;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	FeignRemoteServiceA feignServiceA;
	
	
	/*
	 * 
	 * hystrix 옵션값 설정 example
	   @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
		   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
		   @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),
		   @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),
		   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
		   @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
		}, threadPoolProperties = @HystrixProperty(name = "coreSize", value = "100"))
	 */

	@RequestMapping(path="/test", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "testMethodFallback")//hystrix timeout은 기본1초이기때문에 연산이조금 걸리는 method 는 timeout 옵션을좀 늘려줘야함.
	public String testMethod() {
        return "Service-B: 호출" + " > " + feignServiceA.testMethod();
	}
	
	
	public String testMethodFallback() {//서킷브레이커가 열렸을떄 기본초는 5초이다.
		return "Service-B: 호출 에러";
	}
	
}
