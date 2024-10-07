package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatentException {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<NoSuchElementException> noSuchElementException(){
		NoSuchElementException nosuch = new NoSuchElementException("Id is not found");
		return new ResponseEntity<NoSuchElementException>(nosuch,HttpStatus.NOT_FOUND);
	}

}
