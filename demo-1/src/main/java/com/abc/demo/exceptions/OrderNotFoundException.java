package com.abc.demo.exceptions;

public class OrderNotFoundException extends Exception {
	String message;

	public OrderNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
}
