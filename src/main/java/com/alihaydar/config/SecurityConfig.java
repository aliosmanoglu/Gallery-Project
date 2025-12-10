package com.alihaydar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.alihaydar.handler.AuthEntryPoint;
import com.alihaydar.jwt.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

	
	private final String AUTHENTICATE = "/authenticate";
	private final String REGISTER = "/register";
	private final String REFRESH_TOKEN = "/refreshToken";
	
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private AuthEntryPoint authEntryPoint;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(request ->
				request.requestMatchers(AUTHENTICATE,REGISTER,REFRESH_TOKEN)
				.permitAll()
				.anyRequest()
				.authenticated())
				.exceptionHandling(ex -> ex.authenticationEntryPoint(authEntryPoint))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
}
