package com.alihaydar.enums;

import java.security.PrivateKey;

public enum MessageType {

	NO_RECORD_EXCIST("400","No Record Founded"),
	GENERAL_EXCEPTION("404","General Exception");
	
	
	private String code;
	private String message;
	
	
	MessageType(String code,String message){
		this.code = code;
		this.message = message;
	}
	
}
