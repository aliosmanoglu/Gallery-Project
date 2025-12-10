package com.alihaydar.controller;

import com.alihaydar.dto.AuthRequest;
import com.alihaydar.dto.AuthResponse;
import com.alihaydar.dto.DtoUser;
import com.alihaydar.dto.RefreshTokenRequest;

public interface IRestAuthController {

	
	public RootEntity<DtoUser> register(AuthRequest authRequest); 
	
	
	public RootEntity<AuthResponse> authenticate(AuthRequest authRequest);
	
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest request);
}
