package com.crud.globalexception;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandelException {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<CustomeException> noSuchElementException(NoSuchElementException exception) {

		// String message = exception.getMessage();

		return new ResponseEntity<CustomeException>(new CustomeException("User Id Not Found", true),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<CustomeException> dupilicateUserNameNotAllowed(DataIntegrityViolationException exception) {

		// String message=exception.getMessage();

		return new ResponseEntity<CustomeException>(new CustomeException("User name allready exit", true),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handelMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {

		Map<String, String> allExceptionList = new HashMap<>();

		exception.getBindingResult().getAllErrors().forEach((err) -> {

			String filedName = ((FieldError) err).getField();
			String message = err.getDefaultMessage();
			allExceptionList.put(filedName, message);
		});
		System.err.println(allExceptionList);
		return new ResponseEntity<Map<String, String>>(allExceptionList, HttpStatus.BAD_REQUEST);
	}
}
