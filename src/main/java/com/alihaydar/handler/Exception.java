package com.alihaydar.handler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exception<T> {

	private Date createDate;
	
	private String path;
	
	private String hostName;
	
	private T message;
	
}
