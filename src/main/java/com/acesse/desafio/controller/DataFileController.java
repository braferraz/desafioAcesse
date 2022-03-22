package com.acesse.desafio.controller;

import java.io.IOException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;


import com.acesse.desafio.model.DataFile;
import com.acesse.desafio.repository.DataFileRepository;

@RestController
public class DataFileController {

	@Autowired
	DataFileRepository dataFileRepository;
	
	
	@RequestMapping(value="/upload", method = RequestMethod.POST, produces = {"application/json", "text/xml"})
	public HttpStatus uploadFile(@RequestParam("pdfFile") MultipartFile file) throws IOException {

		DataFile pdf = new DataFile(file.getOriginalFilename(), file.getContentType(),
				file.getBytes());
		dataFileRepository.save(pdf);
		return HttpStatus.OK;
	}
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Resource> getPdf(@PathVariable("id") long pdfId) throws IOException {

		final Optional<DataFile> retrievedPdf = dataFileRepository.findById(pdfId);
		
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(retrievedPdf.get().getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "datafile; filename=\"" + retrievedPdf.get().getName()
                + "\"")
                .body(new ByteArrayResource(retrievedPdf.get().getPdfByte()));
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT, produces = {"application/json", "text/xml"})
	public DataFile uploadFile(@RequestParam("pdfFile") MultipartFile file, @PathVariable("id") long pdfId) throws IOException {
		
		Optional<DataFile> data = dataFileRepository.findById(pdfId);
		data.get().setName(file.getName());
		data.get().setPdfByte(file.getBytes());
		data.get().setType(file.getContentType());
		
		return dataFileRepository.save(data.get());
	}
	
	
}
