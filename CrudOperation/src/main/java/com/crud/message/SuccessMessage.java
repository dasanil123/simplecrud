package com.crud.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SuccessMessage {
	
	private String successMessage;
	
	private boolean isSuccess;
}
