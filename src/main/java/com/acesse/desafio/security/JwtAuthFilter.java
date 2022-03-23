package com.acesse.desafio.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.acesse.desafio.data.UserDetailsData;
import com.acesse.desafio.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter {

	private JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	
	public JwtAuthFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		try {
			User usu = new ObjectMapper().readValue(request.getInputStream(), User.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usu.getEmail(), usu.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException ("Falha na autenticação");
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException{
		UserDetailsData userData = (UserDetailsData) authResult.getPrincipal();
		String token = jwtUtil.generateToken(userData.getUsername());
		response.getWriter().write(token);
		response.getWriter().write(" " + userData.getName());
		response.getWriter().flush();
	}
}
