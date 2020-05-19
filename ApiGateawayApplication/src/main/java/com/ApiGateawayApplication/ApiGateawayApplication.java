package com.ApiGateawayApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import freemarker.ext.beans.CollectionModel;
import lombok.Data;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableZuulProxy


public class ApiGateawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateawayApplication.class, args);
	}

}

@Data
class Car{
	private String name;

}
@FeignClient("car-servie")
interface CarClient{
 @GetMapping("/cars")
 @CrossOrigin
 org.springframework.hateoas.CollectionModel<Car> readCars();
}

@RestController
class CoolController{
	private final CarClient carClient;
	public CoolController(CarClient carClient){
		this.carClient=carClient;
	}
	private Collection<Car> fallback(){
		return new ArrayList<>();
	}
	@GetMapping("/cool-cars")
	@CrossOrigin
	@HystrixCommand(fallbackMethod = "fallback")
	public Collection<Car> goodCars(){
		return carClient.readCars()
			.getContent()
			.stream()
			.filter(this::isCool)
			.collect(Collectors.toList());
	}
	public boolean isCool(Car car){
		return !car.getName().equals("AMC Gremlin")&&
		!car.getName().equals("Triumph Stag")&&
		!car.getName().equals("Ford Pinto") &&
		!car.getName().equals("Yugo GV");
	}
}
