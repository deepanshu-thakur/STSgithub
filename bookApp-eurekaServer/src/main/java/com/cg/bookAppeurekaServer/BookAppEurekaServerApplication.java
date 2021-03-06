package com.cg.bookAppeurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookAppEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAppEurekaServerApplication.class, args);
	}

}
