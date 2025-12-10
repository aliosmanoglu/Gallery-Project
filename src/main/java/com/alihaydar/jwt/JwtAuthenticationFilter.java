package com.alihaydar.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alihaydar.enums.MessageType;
import com.alihaydar.exception.BaseException;
import com.alihaydar.exception.ErrorMessage;
import com.alihaydar.starter.GalleryProjectApplication;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		System.out.println("KONROL FILTER");
		
		String header = request.getHeader("Authorization");
		
		if(header == null) {
			System.out.println("TOKEN YOK");
			filterChain.doFilter(request, response);
			return;
		}
		
		String token;
		String username;
		
		token = header.substring(7);
		
		try {
			username = jwtService.getUsername(token);
			if(username!= null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				if(userDetails != null && jwtService.isTokenValid(token)) {
					UsernamePasswordAuthenticationToken authenticationToken = 
							new UsernamePasswordAuthenticationToken(username,null,userDetails.getAuthorities());
					
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
				
			}
		} 
		catch (ExpiredJwtException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {	
			e.printStackTrace();
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	

}
