package com.alihaydar.exception;


import com.alihaydar.enums.MessageType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

	private MessageType message;
	
	private String ofStatic;
	
	public String prepareErrorMessage() {
		String errorMessage = message.getMessage();
		
		if(this.ofStatic != null) {
			errorMessage += " : " + ofStatic;
		}
		
		return errorMessage;
	}
	
	
}
