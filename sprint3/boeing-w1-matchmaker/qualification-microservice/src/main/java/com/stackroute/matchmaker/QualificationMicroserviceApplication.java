package com.stackroute.matchmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class QualificationMicroserviceApplication {

	 //The starting point of the Qualification MicroService
	
	public static void main(String[] args) {
		SpringApplication.run(QualificationMicroserviceApplication.class, args);
		
	}
}
