package com.hrs.userservice.schedular;

import org.springframework.stereotype.Component;

@Component
public class SubscriptionExpiredSchedular {
	
//	@Scheduled(initialDelay = 10000, fixedDelay = 10000)
	public void checkSubscriptionExpired() {
//		System.out.println("Expired! " + new Date());
	}
}
