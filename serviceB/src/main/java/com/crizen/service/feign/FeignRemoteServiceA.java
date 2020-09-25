package com.crizen.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-a")
public interface FeignRemoteServiceA {

	@RequestMapping("/api/test")
    String testMethod();
	
}
