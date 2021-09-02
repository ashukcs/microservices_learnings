package com.hrs.springboot.exceptionhandling.model;

public class Response<T> {

    private Status status;
    private T data;

	public Response(Status status, T data) {
		super();
		this.status = status;
		this.data = data;
	}
	public Response() {
		super();
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}