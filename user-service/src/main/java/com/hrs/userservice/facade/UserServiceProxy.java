package com.hrs.userservice.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hrs.userservice.payload.SubscriptionPayload;

@FeignClient(name = "SUBSCRIPTION-SERVICE")
public interface UserServiceProxy {
	
	@GetMapping("/subscriptionService/getSubscription/{userId}")
	public SubscriptionPayload getSubscriptionData(@PathVariable("userId") String userId);

}
