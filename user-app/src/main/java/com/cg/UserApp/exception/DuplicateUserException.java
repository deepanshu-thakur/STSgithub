package com.cg.UserApp.exception;

public class DuplicateUserException extends RuntimeException{
	public DuplicateUserException(String message)
	{
		super(message);
	}

}
