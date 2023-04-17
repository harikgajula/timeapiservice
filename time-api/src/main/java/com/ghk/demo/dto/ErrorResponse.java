package com.ghk.demo.dto;

public class ErrorResponse {
	
	private int value;
	private String exceptionName;
	private String message;
	
	public ErrorResponse(int value, String exceptionName, String message) {
		
		this.value = value;
		this.exceptionName = exceptionName;
		this.message = message;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}
