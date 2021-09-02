package com.hrs.usersubscription.services;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.hrs.usersubscription.entity.Subscription;
import com.hrs.usersubscription.payload.SubscriptionPayload;
import com.hrs.usersubscription.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	@Value("${server.port}")
	private String port;
	
	@Autowired
	protected SubscriptionRepository subscriptionRepository;

	@Override
	public SubscriptionPayload createSubscription(SubscriptionPayload subscriptionPayload) {
		Subscription subscription = subscriptionRepository.findByUserId(subscriptionPayload.getUserId());
		if(ObjectUtils.isEmpty(subscription)) {
			subscription = new Subscription();
			subscription.setUserId(subscriptionPayload.getUserId());
			subscription.setStartDate(new Date());
			subscription.setExpiryDate(Date.from(Instant.now().plusSeconds(7*24*60*60)));
			subscriptionPayload = subscriptionRepository.save(subscription).mapToSubscriptionPayload();
		} else {
			throw new IllegalArgumentException("User Already Exist!!");
		}
		
		return subscriptionPayload;
	}

	@Override
	public SubscriptionPayload getSubscription(String userId) {
		SubscriptionPayload subscriptionPayload = null;
		if (StringUtils.hasLength(userId)) {
			Subscription existingSubscription = subscriptionRepository.findByUserId(userId);
			
			if(!ObjectUtils.isEmpty(existingSubscription)) {
				existingSubscription.setPort(port);
				subscriptionPayload = existingSubscription.mapToSubscriptionPayload();
			}
		} else {
			throw new IllegalArgumentException("Invalid Data!");
		}
		return subscriptionPayload;
	}
	
	/*
	 * @Override public SubscriptionPayload getSubscription(String id) {
	 * SubscriptionPayload subscriptionPayload = null; if
	 * (StringUtils.hasLength(id)) { Optional<Subscription> subscription =
	 * subscriptionRepository.findById(id);
	 * 
	 * if(subscription.isPresent()) { Subscription existingSubscription =
	 * subscription.get(); subscriptionPayload = new
	 * SubscriptionPayload(existingSubscription.getId(),
	 * existingSubscription.getUserId(), existingSubscription.getCreatedDate(),
	 * existingSubscription.getExpiryDate()); } else { throw new
	 * IllegalArgumentException("Subscription does not Exist"); } } else { throw new
	 * IllegalArgumentException("Invalid Data!"); } return subscriptionPayload; }
	 */


	@Override
	public Boolean deleteSubscription(String id) {
		if(StringUtils.hasLength(id)) {
			subscriptionRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Subscription does not Exist");
		}
		return true;
	}
}
