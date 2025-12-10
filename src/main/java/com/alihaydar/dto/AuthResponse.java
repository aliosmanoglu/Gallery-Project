package com.alihaydar.dto;

import com.alihaydar.model.RefreshToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

	private String accessToken;
	
	private RefreshToken refreshToken;
	
}
