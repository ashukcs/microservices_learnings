package com.hrs.userservice.payload;

import java.util.Date;

import com.hrs.userservice.entity.User;

public class UserPayload {
	private String userId;
	private String firstName;
	private String lastName;
	private Integer age;
	private Date createdDate;
	private SubscriptionPayload subscription;

	public UserPayload(String userId, String firstName, String lastName, Integer age, Date createdDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.createdDate = createdDate;
	}

	public UserPayload(User user) {
		this.userId = user.getUserId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.age = user.getAge();
		this.createdDate = user.getCreatedDate();
	}

	public UserPayload() {
	}

	public UserPayload(User user, SubscriptionPayload subscription) {
		this(user);
		setSubscription(subscription);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public SubscriptionPayload getSubscription() {
		return subscription;
	}

	public void setSubscription(SubscriptionPayload subscription) {
		this.subscription = subscription;
	}

	public User mapToUser() {
		return new User(getUserId(), getFirstName(), getLastName(), getAge(), getCreatedDate());
	}
}
