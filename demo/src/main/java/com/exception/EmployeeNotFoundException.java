package com.exception;

public class EmployeeNotFoundException extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EmployeeNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "EmployeeNotFoundException [message=" + message + "]";
	}
	
}
