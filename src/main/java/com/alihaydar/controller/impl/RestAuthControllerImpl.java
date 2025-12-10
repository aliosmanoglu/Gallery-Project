package com.alihaydar.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alihaydar.controller.IRestAuthController;
import com.alihaydar.controller.RestEntityBase;
import com.alihaydar.controller.RootEntity;
import com.alihaydar.dto.AuthRequest;
import com.alihaydar.dto.AuthResponse;
import com.alihaydar.dto.DtoUser;
import com.alihaydar.dto.RefreshTokenRequest;
import com.alihaydar.service.impl.RestAuthServiceImpl;


@RestController
public class RestAuthControllerImpl extends RestEntityBase implements IRestAuthController {

	@Autowired
	private RestAuthServiceImpl restAuthService;
	
	@PostMapping("/register")
	@Override
	public RootEntity<DtoUser> register(@RequestBody AuthRequest authRequest) {
		return ok(restAuthService.register(authRequest));
	}

	@PostMapping("/authenticate")
	@Override
	public RootEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
		return ok(restAuthService.authenticate(authRequest));
	}

	@PostMapping("/refreshToken")
	@Override
	public RootEntity<AuthResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
		System.out.println("REFRESH KONTROL");
		return ok(restAuthService.refreshToken(request));
	}

}
