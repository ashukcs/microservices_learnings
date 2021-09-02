package com.hrs.usersubscription.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hrs.usersubscription.payload.SubscriptionPayload;

@Document(collection = "subscription")
public class Subscription {
	@Id
	private String id;
	private String userId;
	private Date startDate;
	private Date expiryDate;
	@Transient
	private String port;

	public Subscription() {
	}

	public Subscription(String userId, Date startDate, Date expiryDate, String port) {
		this.userId = userId;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
		this.port = port;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public SubscriptionPayload mapToSubscriptionPayload() {
		return new SubscriptionPayload(getUserId(), getStartDate(), getExpiryDate(), getPort());
	}
}
