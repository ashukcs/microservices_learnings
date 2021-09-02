package com.hrs.gatewayserver.controller;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

//@RestController
//@EnableHystrix
public class FallbackController {
	
//	@RequestMapping("/userServiceFallback")
	public Mono<String> userServiceFallback(){
		return Mono.just("User Service taking too long to respond or is down. Please try again later");
	}

//	@RequestMapping("/subscriptionServiceFallback")
	public Mono<String> subscriptionServiceFallback(){
		return Mono.just("Subscription Service taking too long to respond or is down. Please try again later");
	}
}
