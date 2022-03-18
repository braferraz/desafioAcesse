package com.acesse.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acesse.desafio.model.Process;
import com.acesse.desafio.repository.ProcessRepository;

@RestController
public class ProcessController {

	@Autowired 
	ProcessRepository processRepository;
	
	@PostMapping("process/new")
	public Process Post(@RequestBody Process process) {
		return processRepository.save(process);
	}
}
