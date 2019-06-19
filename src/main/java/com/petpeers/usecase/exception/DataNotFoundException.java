package com.petpeers.usecase.exception;

public class DataNotFoundException extends Exception {
	
	private String message;
 
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public DataNotFoundException(String message) {
		super();
		this.message = message;
	}
	

}
