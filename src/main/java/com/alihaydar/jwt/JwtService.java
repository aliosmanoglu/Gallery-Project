package com.alihaydar.jwt;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.alihaydar.starter.GalleryProjectApplication;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {


	
	@Value("${jwt.SECRET_KEY}")
	private String SECRET_KEY;

 
	public String generateToken(UserDetails userDetails) {
	
		return Jwts.builder()
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*2))
				.signWith(getKey(),SignatureAlgorithm.HS256)
				.compact();
	}
	
	public Claims getClaims(String token) {
		return Jwts.parser()
				.verifyWith(getKey())
				.build()
				.parseSignedClaims(token).getBody();
	}
	
	
	public <T> T exportToken(String token, Function<Claims, T> claimsFunc){
		Claims claims = getClaims(token);
		return claimsFunc.apply(claims);
		
	}
	
	public Date getExpireDate(String token) {
		return exportToken(token, Claims::getExpiration);
	}
	
	public boolean isTokenValid(String token) {
		Date date = new Date();
		return date.before(getExpireDate(token));
	}
	
	public String getUsername(String token) {
		return exportToken(token, Claims::getSubject);
	}
	
	private SecretKey getKey() {
		byte[] bytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(bytes);
	}
}
