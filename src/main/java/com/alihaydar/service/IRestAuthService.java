package com.alihaydar.service;

import com.alihaydar.controller.RootEntity;
import com.alihaydar.dto.AuthRequest;
import com.alihaydar.dto.AuthResponse;
import com.alihaydar.dto.DtoUser;
import com.alihaydar.dto.RefreshTokenRequest;

public interface IRestAuthService {

	public DtoUser register(AuthRequest authRequest);
	
	public AuthResponse authenticate(AuthRequest authRequest);
	
	
	public AuthResponse refreshToken(RefreshTokenRequest request);
}
