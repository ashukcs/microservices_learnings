package com.hrs.userservice.payload;

import java.util.Date;

public class SubscriptionPayload {
	private String port;
	private Date startDate;
	private Date expiryDate;

	public SubscriptionPayload(String port, Date startDate, Date expiryDate) {
		this.port = port;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
	}
	
	public SubscriptionPayload() {
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
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
}
