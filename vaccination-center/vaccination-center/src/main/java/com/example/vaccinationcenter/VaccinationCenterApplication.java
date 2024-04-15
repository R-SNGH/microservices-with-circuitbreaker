package com.example.vaccinationcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
//@EnableCircuitBreaker
public class VaccinationCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationCenterApplication.class, args);
	}

	@Bean
	@LoadBalanced // to add a load balanced rest template
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
