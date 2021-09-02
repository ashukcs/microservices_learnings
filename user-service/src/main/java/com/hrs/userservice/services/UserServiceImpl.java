package com.hrs.userservice.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.hrs.userservice.entity.User;
import com.hrs.userservice.facade.UserServiceProxy;
import com.hrs.userservice.payload.SubscriptionPayload;
import com.hrs.userservice.payload.UserPayload;
import com.hrs.userservice.repository.UserRepository;

@Service
@RefreshScope
public class UserServiceImpl implements UserService {

	@Autowired
	protected UserServiceProxy proxy;
	
	@Autowired
	protected UserRepository userRepository;

	@Autowired
	@Lazy
	protected RestTemplate restTemplate;
	
	@Value("${microservice.user-service.endpoints.endpoint.uri}")
	private String SUBSCRIPTION_ENDPOINT_URL;

	@Override
	public UserPayload createUser(UserPayload userPayload) {
		UserPayload newUserPayload = null;
		if(StringUtils.hasLength(userPayload.getUserId()) || StringUtils.hasLength(userPayload.getFirstName()) || StringUtils.hasLength(userPayload.getLastName()) || (userPayload.getAge() != null && userPayload.getAge() > 18)) {
			userPayload.setCreatedDate(new Date());
			newUserPayload = userRepository.save(userPayload.mapToUser()).mapToUserPayload();
		} else {
			throw new IllegalArgumentException("Invalid Data!");
		}
		
		return newUserPayload;
	}

	@Override
	public UserPayload getUser(String userId) {
		UserPayload userPayload = null;
		if (StringUtils.hasLength(userId)) {
			Optional<User> user = userRepository.findById(userId);
			
			if(user.isPresent()) {
				User existingUser = user.get();
//				SubscriptionPayload subscriptionPayload = getSubscriptionData(userId);
				SubscriptionPayload subscriptionPayload = proxy.getSubscriptionData(userId);
				userPayload = new UserPayload(existingUser, subscriptionPayload);
			} else {
				throw new IllegalArgumentException("User does not Exist");
			}
		} else {
			throw new IllegalArgumentException("Invalid Data!");
		}
		return userPayload;
	}


	@Override
	public Boolean deleteUser(String userId) {
		if(StringUtils.hasLength(userId)) {
			userRepository.deleteById(userId);
		} else {
			throw new IllegalArgumentException("User does not Exist");
		}
		return true;
	}

	@Override
	public SubscriptionPayload getSubscriptionData(String userId) {
		String url = SUBSCRIPTION_ENDPOINT_URL+userId;
		ResponseEntity<SubscriptionPayload> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, SubscriptionPayload.class);
			return responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Invalid Data!");
		}
	}
}
