package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerControllerAdvice {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> customerExceptionHandler(CustomerNotFoundException exception){
		CustomerErrorResponse theCustomerErrorResponse = new CustomerErrorResponse();
		
		theCustomerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		theCustomerErrorResponse.setMessage(exception.getMessage());
		theCustomerErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(theCustomerErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<CustomerErrorResponse> customerExceptionHandler(Exception exception){
		CustomerErrorResponse theCustomerErrorResponse = new CustomerErrorResponse();
		
		theCustomerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		theCustomerErrorResponse.setMessage(exception.getMessage());
		theCustomerErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(theCustomerErrorResponse, HttpStatus.BAD_REQUEST);
	}
}
