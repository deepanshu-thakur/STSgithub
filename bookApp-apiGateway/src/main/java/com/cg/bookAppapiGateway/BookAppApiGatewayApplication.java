package com.cg.bookAppapiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookAppApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAppApiGatewayApplication.class, args);
	}

}
