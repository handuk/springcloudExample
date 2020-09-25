package com.crizen.gw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.crizen.gw.config.PreFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ApigwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigwApplication.class, args);
	}
	
	@Bean
	public PreFilter preFilter() {
        return new PreFilter();
    }

}
