package com.hrs.userservice.services;

import com.hrs.userservice.payload.SubscriptionPayload;
import com.hrs.userservice.payload.UserPayload;

public interface UserService {
	public UserPayload createUser(UserPayload user);
	public UserPayload getUser(String userId);
	public Boolean deleteUser(String userId);
	public SubscriptionPayload getSubscriptionData(String userId);
}
