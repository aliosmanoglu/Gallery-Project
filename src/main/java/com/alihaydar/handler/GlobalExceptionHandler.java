package com.alihaydar.handler;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.net.http.HttpRequest;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.alihaydar.controller.RootEntity;
import com.alihaydar.controller.impl.RestAuthControllerImpl;
import com.alihaydar.dto.AuthRequest;
import com.alihaydar.dto.DtoUser;
import com.alihaydar.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final RestAuthControllerImpl restAuthControllerImpl;

    GlobalExceptionHandler(RestAuthControllerImpl restAuthControllerImpl) {
        this.restAuthControllerImpl = restAuthControllerImpl;
    }

	@ExceptionHandler(value = {BaseException.class} )
	public ResponseEntity<ApiError<?>> handleBaseException(BaseException ex, WebRequest request) {
		return ResponseEntity.badRequest().body(createApiError(ex.getMessage(), request));
	}

	
	public String getHostName() {
		try {
			return Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return "";
	}

	
	public <T> ApiError<T> createApiError(T message, WebRequest request){
		ApiError<T> apiError = new ApiError<>();
		apiError.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		Exception<T> exception = new Exception<>();
		exception.setPath(request.getDescription(false));
		exception.setCreateDate(new Date());
		exception.setMessage(message);
		exception.setHostName(getHostName());
		
		return null;
	}
	
}
