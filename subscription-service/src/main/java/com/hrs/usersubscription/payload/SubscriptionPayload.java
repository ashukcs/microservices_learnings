package com.hrs.usersubscription.payload;

import java.util.Date;

import com.hrs.usersubscription.entity.Subscription;

public class SubscriptionPayload {
	private String userId;
	private Date startDate;
	private Date expiryDate;
	private String port;

	public SubscriptionPayload() {
	}

	public SubscriptionPayload(String userId, Date startDate, Date expiryDate, String port) {
		this.userId = userId;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.port = port;
	}

	public SubscriptionPayload(String userId, Date startDate, Date expiryDate) {
		this.userId = userId;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Subscription mapToSubscription() {
		return new Subscription(getUserId(), getStartDate(), getExpiryDate(), getPort());
	}
}
