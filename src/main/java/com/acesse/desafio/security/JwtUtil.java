package com.acesse.desafio.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtil {
	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;
	
	public String generateToken(String username) {
		return JWT.create()
				.withSubject(username)
				.withExpiresAt(new Date(System.currentTimeMillis() + expiration))
				.sign(Algorithm.HMAC512(secret.getBytes()));
				
	}
	
	public String validToken(String token) {
		return JWT.require(Algorithm.HMAC512(secret.getBytes()))
			.build()
			.verify(token)
			.getSubject();
	}
}