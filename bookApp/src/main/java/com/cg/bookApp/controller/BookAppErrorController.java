package com.cg.bookApp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.bookApp.dto.ErrorResponse;
import com.cg.bookApp.exception.DuplicateBookException;
import com.cg.bookApp.exception.BookNotFoundException;

@RestControllerAdvice
public class BookAppErrorController {

	@ExceptionHandler(value = {BookNotFoundException.class})
	
	public ResponseEntity<ErrorResponse> handleBookNotFoundException(Exception ex, HttpServletRequest request) {
		ErrorResponse body= new ErrorResponse(LocalDateTime.now(),
									HttpStatus.NOT_FOUND.value() , 
									ex.getClass().getSimpleName(), 
									ex.getLocalizedMessage(), 
									request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}
	@ExceptionHandler(value = {DuplicateBookException.class})
	// @ResponseStatus(code = HttpStatus.CONFLICT)
	public ResponseEntity<ErrorResponse> handleDuplicateBookException(Exception ex, HttpServletRequest request) {
		ErrorResponse body= new ErrorResponse(LocalDateTime.now(),
									HttpStatus.CONFLICT.value() , 
									ex.getClass().getSimpleName(), 
									ex.getLocalizedMessage(), 
									request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
	}
}
