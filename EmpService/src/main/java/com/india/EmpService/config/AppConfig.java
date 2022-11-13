package com.india.EmpService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.india.EmpService.Service.EmpService;

@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public EmpService empService() {
		return new EmpService();
	}
}
