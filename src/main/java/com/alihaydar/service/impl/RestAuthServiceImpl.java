package com.alihaydar.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.alihaydar.controller.RootEntity;
import com.alihaydar.controller.impl.RestAuthControllerImpl;
import com.alihaydar.dto.AuthRequest;
import com.alihaydar.dto.AuthResponse;
import com.alihaydar.dto.DtoUser;
import com.alihaydar.dto.RefreshTokenRequest;
import com.alihaydar.enums.MessageType;
import com.alihaydar.exception.BaseException;
import com.alihaydar.exception.ErrorMessage;
import com.alihaydar.jwt.JwtService;
import com.alihaydar.model.RefreshToken;
import com.alihaydar.model.User;
import com.alihaydar.repository.RefreshTokenRepository;
import com.alihaydar.repository.UserRepository;
import com.alihaydar.service.IRestAuthService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;


@Service
public class RestAuthServiceImpl implements IRestAuthService {



	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

    
	public User createUser(AuthRequest authRequest) {
		
		User user = new User();
		
		user.setUsername(authRequest.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(authRequest.getPassword()));
		user.setCreatedDate(new Date());
		
		return user;
	}
	
	@Override
	public DtoUser register(AuthRequest authRequest) {
		
		DtoUser dtoUser = new DtoUser();
		
		User savedUser = userRepository.save(createUser(authRequest));
		
		BeanUtils.copyProperties(savedUser, dtoUser);
		
		return dtoUser;
	}
	
	public RefreshToken createRefreshToken(User user) {
		RefreshToken refreshToken = new RefreshToken();
		
		refreshToken.setUser(user);
		refreshToken.setCreatedDate(new Date());
		refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		
		return refreshToken;
	}

	@Override
	public AuthResponse authenticate(AuthRequest authRequest) {
		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword());

			authenticationProvider.authenticate(usernamePasswordAuthenticationToken);
			
			
			Optional<User> optUser = userRepository.findByUsername(authRequest.getUsername());
			
			
			String token = jwtService.generateToken(optUser.get());
			RefreshToken refreshToken = refreshTokenRepository.save(createRefreshToken(optUser.get()));
			
			return new AuthResponse(token,refreshToken);
			
			
		} catch (Exception e) {
			
		}
		
		
		return null;
	}

	
	public boolean isTokenExpired(Date expiredDate) {
		return new Date().before(expiredDate);
	}
	
	@Override
	public AuthResponse refreshToken(RefreshTokenRequest request) {
		Optional<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());
		System.out.println("refresh token : "  + request.getRefreshToken());
		
		
		if(optRefreshToken.isEmpty()) {
			System.out.println("IS EMPTY KONTORL");
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_IS_NOT_FOUNDED,request.getRefreshToken()));
		}
		
		if(isTokenExpired(optRefreshToken.get().getExpiredDate())) {
			System.out.println("EXPIRED DATE KONTROL");
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_EXPIRED,request.getRefreshToken()));
		}
		
		User user = optRefreshToken.get().getUser();
		
		String token = jwtService.generateToken(user);
		RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(user));
		
		
		return new AuthResponse(token,optRefreshToken.get());
	}
	
}
