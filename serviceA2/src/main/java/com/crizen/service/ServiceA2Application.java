package com.crizen.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceA2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceA2Application.class, args);
	}

}
