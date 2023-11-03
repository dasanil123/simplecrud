package com.crud.globalexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CustomeException {
	
	private String message;
	
	private boolean isException;
		
}
