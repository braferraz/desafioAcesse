package com.acesse.desafio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="process/all", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public Page<Process> listAll(Pageable pageable){
		return processRepository.findActiveProcess(pageable);
	}

	@RequestMapping(value="process/edit/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public Optional<Process> getById(@PathVariable(value = "id") long id){
			return processRepository.findById(id);
	}
	
	@RequestMapping(value="process/delete/{id}", method = RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Process> deleteProcess(@PathVariable(value="id") long id, @RequestBody Process newProcess) {
		Optional<Process> oldProcess = processRepository.findById(id);
		if(oldProcess.isPresent()) {
			Process process = oldProcess.get();
			
			process.setActive(false);
			
			processRepository.save(process);
			return new ResponseEntity<Process>(process, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
