package com.alihaydar.exception;

import lombok.Getter;

@Getter
public class ErrorMessage {

	private String message;
	
	private String ofStatic;
	
	public String prepareErrorMessage() {
		String errorMessage = this.message;
		
		if(this.ofStatic != null) {
			errorMessage += " : " + ofStatic;
		}
		
		return errorMessage;
	}
	
	
}
