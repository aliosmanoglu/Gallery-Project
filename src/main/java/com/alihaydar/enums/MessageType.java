package com.alihaydar.enums;

import java.security.PrivateKey;

import lombok.Getter;


@Getter
public enum MessageType {

	NO_RECORD_EXCIST("400","No Record Founded"),
	EXPIRED_JWT_EXCEPTON("1000", "Token expired"),
	GENERAL_EXCEPTION("404","General Exception"),
	REFRESH_TOKEN_IS_NOT_FOUNDED("1001","Refresh token bulunamadı"),
	REFRESH_TOKEN_EXPIRED("1002","REFREH TOKEN EXPIRED"),
	CURRENCY_ERROR_OCCURED("1003","Currency servisinde hata"),
	CAR_STATUS_IS_ALREADY_SALED("1004","Car already saled!!"),
	CUSTOMER_AMOUNT_IS_NOT_ENOUGH("1005","Customer amount is not enough!!");
	
	private String code;
	private String message;
	
	
	MessageType(String code,String message){
		this.code = code;
		this.message = message;
	}
	
}
