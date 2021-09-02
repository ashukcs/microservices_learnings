package com.hrs.userservice.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hrs.userservice.payload.UserPayload;

import lombok.Data;

@Document(collection = "user")
@Data
public class User {
	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private Integer age;
	private Date createdDate;

	public User(String userId, String firstName, String lastName, Integer age, Date createdDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.createdDate = createdDate;
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

	public UserPayload mapToUserPayload() {
		return new UserPayload(getUserId(), getFirstName(), getLastName(), getAge(), getCreatedDate());
	}
}
