package com.hrs.springboot.exceptionhandling.exception;

import com.hrs.springboot.exceptionhandling.constants.StatusConstants;

public class CanNotGetResponseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private StatusConstants.HttpConstants status;

    public CanNotGetResponseException(StatusConstants.HttpConstants status) {
        super(status.getDesc(), null);
        this.status = status;
    }

	public StatusConstants.HttpConstants getStatus() {
		return status;
	}

	public void setStatus(StatusConstants.HttpConstants status) {
		this.status = status;
	}
    
}
