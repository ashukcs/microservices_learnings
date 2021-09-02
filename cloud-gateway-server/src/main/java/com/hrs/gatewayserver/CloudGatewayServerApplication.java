package com.hrs.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableCircuitBreaker
public class CloudGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayServerApplication.class, args);
	}

	@RequestMapping("/userServiceFallback")
	public Mono<String> userServiceFallback(){
		return Mono.just("User Service taking too long to respond or is down. Please try again later");
	}

	@RequestMapping("/subscriptionServiceFallback")
	public Mono<String> subscriptionServiceFallback(){
		return Mono.just("Subscription Service taking too long to respond or is down. Please try again later");
	}
//	@Bean
//	  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//		System.out.println("********************************************calling through API gateway server***************************************************");
//	    return builder.routes()
//	      .route(p -> p
//	        .path("/userService")
////	        .filters(f -> f.addRequestHeader("Hello", "World"))
//	        .uri("http://USER-SERVICE"))
//	      .route(p -> p
//	        .path("/subscriptionService")
//	        .filters(f -> f
//	          .hystrix(config -> config
//	            .setName("subscriptionService")
//	            .setFallbackUri("forward:/fallback")))
//	        .uri("http://SUBSCRIPTION-SERVICE"))
//	      .build();
//	  }
////
////	  @RequestMapping("/fallback")
////	  public Mono<String> fallback() {
////	    return Mono.just("fallback");
////	  }
}
