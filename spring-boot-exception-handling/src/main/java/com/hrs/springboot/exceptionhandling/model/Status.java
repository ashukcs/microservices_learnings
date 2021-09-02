package com.hrs.springboot.exceptionhandling.model;

import com.hrs.springboot.exceptionhandling.constants.StatusConstants;

public class Status {

    public Integer code;

    public String message;

    public Status(StatusConstants.HttpConstants httpConstants) {
        this.code = httpConstants.getCode();
        this.message = httpConstants.getDesc();
    }

	public Status() {
		super();
	}

	public Status(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}