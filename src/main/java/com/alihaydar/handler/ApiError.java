package com.alihaydar.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError<T> {

	private Integer errorCode;
	
	private Exception<T> exception;
}
