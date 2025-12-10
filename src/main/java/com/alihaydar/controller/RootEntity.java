package com.alihaydar.controller;

import com.alihaydar.handler.ApiError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = Include.NON_NULL)
public class RootEntity<T> {

	private Integer status;
	
	private T data;
	
	private String error;
	
	
	
	public static <T> RootEntity<T> ok(T payload) {
		RootEntity<T> rootEntity = new RootEntity<>();
		
		rootEntity.setStatus(200);
		rootEntity.setData(payload);
		rootEntity.setError(null);
		
		return rootEntity;
	}
	
	
	public static <T> RootEntity<T> error(String errorMessage) {
		RootEntity<T> rootEntity = new RootEntity<>();
		
		rootEntity.setStatus(200);
		rootEntity.setData(null);
		rootEntity.error(errorMessage);
		
		return rootEntity;
	}
	
}
