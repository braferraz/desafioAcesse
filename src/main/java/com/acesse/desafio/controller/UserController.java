package com.acesse.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.acesse.desafio.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value="/getUser/{email}")
	public String getUser(@PathVariable(value="email") String email) {
		String usu = userRepository.findByEmail(email).get().getName();
		System.out.println(usu);
		return usu;
	}
}
