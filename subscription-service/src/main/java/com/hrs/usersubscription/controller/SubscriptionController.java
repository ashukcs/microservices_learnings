package com.hrs.usersubscription.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrs.usersubscription.payload.SubscriptionPayload;
import com.hrs.usersubscription.services.SubscriptionService;

@RestController
@RequestMapping("/subscriptionService")
public class SubscriptionController {

	private final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);
	
	@Autowired
	SubscriptionService subscriptionService;

	@PostMapping(value = "/addSubscription")
	public ResponseEntity<SubscriptionPayload> createSubscription(@RequestBody SubscriptionPayload subscriptionPayload) {
		try {
			logger.info("Subscription Service createSubscription request : {}", new ObjectMapper().writeValueAsString(subscriptionPayload));
			subscriptionPayload = subscriptionService.createSubscription(subscriptionPayload);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(subscriptionPayload, HttpStatus.OK);
	}

	@PutMapping(value = "/updateSubscription")
	public ResponseEntity<SubscriptionPayload> updateSubscription(@RequestBody SubscriptionPayload subscriptionPayload) {
		try {
			logger.info("Subscription Service updateSubscription request : {}", new ObjectMapper().writeValueAsString(subscriptionPayload));
			subscriptionPayload = subscriptionService.createSubscription(subscriptionPayload);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(subscriptionPayload, HttpStatus.OK);
	}

	@GetMapping(value = "/getSubscription/{userId}")
	public ResponseEntity<SubscriptionPayload> getSubscription(@PathVariable String userId) {
		SubscriptionPayload subscriptionPayload = null;
		try {
			logger.info("Subscription Service getSubscription request : {}", userId);
			subscriptionPayload = subscriptionService.getSubscription(userId);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(subscriptionPayload, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteSubscription/{id}")
	public ResponseEntity<Boolean> deleteSubscription(@PathVariable String id) {
		try {
			logger.info("Subscription Service deleteSubscription request : {}", id);
			subscriptionService.deleteSubscription(id);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
