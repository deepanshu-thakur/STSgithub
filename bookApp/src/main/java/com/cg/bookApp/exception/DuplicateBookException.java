package com.cg.bookApp.exception;

public class DuplicateBookException extends RuntimeException {

	public DuplicateBookException(String message)
	{
		super(message);
	}
}
