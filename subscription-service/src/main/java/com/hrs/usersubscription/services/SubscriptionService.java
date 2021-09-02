package com.hrs.usersubscription.services;

import com.hrs.usersubscription.payload.SubscriptionPayload;

public interface SubscriptionService {
	public SubscriptionPayload createSubscription(SubscriptionPayload subscriptionPayload);
	public SubscriptionPayload getSubscription(String id);
	public Boolean deleteSubscription(String id);
}
