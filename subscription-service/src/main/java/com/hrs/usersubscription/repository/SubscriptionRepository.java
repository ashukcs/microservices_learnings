package com.hrs.usersubscription.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hrs.usersubscription.entity.Subscription;

public interface SubscriptionRepository extends MongoRepository<Subscription, String>{

	Subscription findByUserId(String userId);
}
