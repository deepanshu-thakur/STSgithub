package com.cg.UserApp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.UserApp.dto.ErrorResponse;
import com.cg.UserApp.exception.UserNotFoundException;
import com.cg.UserApp.exception.DuplicateUserException;

@RestControllerAdvice
public class UserAppErrorController {

@ExceptionHandler(value = {UserNotFoundException.class})
	
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception ex, HttpServletRequest request) {
		ErrorResponse body= new ErrorResponse(LocalDateTime.now(),
									HttpStatus.NOT_FOUND.value() , 
									ex.getClass().getSimpleName(), 
									ex.getLocalizedMessage(), 
									request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
	@ExceptionHandler(value = {DuplicateUserException.class})
	// @ResponseStatus(code = HttpStatus.CONFLICT)
	public ResponseEntity<ErrorResponse> handleDuplicateUserException(Exception ex, HttpServletRequest request) {
		ErrorResponse body= new ErrorResponse(LocalDateTime.now(),
									HttpStatus.CONFLICT.value() , 
									ex.getClass().getSimpleName(), 
									ex.getLocalizedMessage(), 
									request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
	}
}
