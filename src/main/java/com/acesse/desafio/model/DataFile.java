package com.acesse.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="datafile")
public class DataFile {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;
	
	@Column(name = "pdfByte")
	private byte[] pdfByte;

	public DataFile() {
		
	}
	public DataFile(String name, String type, byte[] pdfByte) {
		this.name = name;
		this.type = type;
		this.pdfByte = pdfByte;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPdfByte() {
		return pdfByte;
	}

	public void setPdfByte(byte[] pdfByte) {
		this.pdfByte = pdfByte;
	}
	
	
}
