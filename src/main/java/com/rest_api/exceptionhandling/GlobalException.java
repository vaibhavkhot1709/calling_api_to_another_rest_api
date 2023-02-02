package com.rest_api.exceptionhandling;

public class GlobalException extends Exception{
	
	String massage;

	public GlobalException(String message) {
		super(message);
	}
	
	

}
