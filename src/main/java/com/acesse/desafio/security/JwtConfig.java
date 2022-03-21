package com.acesse.desafio.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.acesse.desafio.service.UserDetailsServiceImpl;


@EnableWebSecurity
public class JwtConfig extends WebSecurityConfigurerAdapter{

	private final UserDetailsServiceImpl userService;
	private final PasswordEncoder passwordEncoder;
	
	public JwtConfig(UserDetailsServiceImpl userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST,"/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilter(new JwtAuthFilter(authenticationManager()))
			.addFilter(new JwtFilterValidation(authenticationManager()))
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
