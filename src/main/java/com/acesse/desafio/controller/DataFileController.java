package com.acesse.desafio.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.acesse.desafio.model.DataFile;
import com.acesse.desafio.repository.DataFileRepository;
import com.acesse.desafio.service.DataFileService;

@RestController
public class DataFileController {

	@Autowired
	DataFileRepository dataFileRepository;
	@Autowired
	DataFileService dataFileService;
	
	
	@RequestMapping(value="/upload", method = RequestMethod.POST, produces = {"application/json", "text/xml"})
	public HttpStatus uploadFile(@RequestParam("pdfFile") MultipartFile file) throws IOException {

		DataFile pdf = new DataFile(file.getOriginalFilename(), file.getContentType(),
				dataFileService.compressBytes(file.getBytes()));
		dataFileRepository.save(pdf);
		return HttpStatus.OK;
	}
	
	
}
