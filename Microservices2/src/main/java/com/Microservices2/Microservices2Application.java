package com.Microservices2;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableEurekaServer

public class Microservices2Application {

	public static void main(String[] args) {
	//	System.setProperty("spring.config.name", "registration-server");
		SpringApplication.run(Microservices2Application.class, args);
	}

}
