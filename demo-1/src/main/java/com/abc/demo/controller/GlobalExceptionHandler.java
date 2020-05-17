package com.abc.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abc.demo.exceptions.ItemNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {ItemNotFoundException.class})
	public ResponseEntity<?> getErrorResponse(){
		String bodyOfResponse = "No User found";
        return new ResponseEntity<>(bodyOfResponse,HttpStatus.UNAUTHORIZED);
	}
	

}
