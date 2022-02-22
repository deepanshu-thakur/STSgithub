package com.cg.UserApp.exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message)
	{
		super(message);
	}
}
