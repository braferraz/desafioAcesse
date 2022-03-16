package com.acesse.desafio.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Process {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numberProcess;
	private String subject;
	private String applicantsName;
	private int zipCode;
	private String city;
	private String district;
	private String street;
	private int number;
	private Date processDate;
	private Date creationDate;
	private boolean active;
	
	@Lob
	private byte[] data;

	public Process(Long numberProcess, String subject, String applicantsName, int zipCode, String city, String district,
			String street, int number, Date processDate, Date creationDate, byte[] data, boolean active) {
		super();
		this.numberProcess = numberProcess;
		this.subject = subject;
		this.applicantsName = applicantsName;
		this.zipCode = zipCode;
		this.city = city;
		this.district = district;
		this.street = street;
		this.number = number;
		this.processDate = processDate;
		this.creationDate = creationDate;
		this.data = data;
		this.active = active;
	}

	public Long getNumberProcess() {
		return numberProcess;
	}

	public void setNumberProcess(Long numberProcess) {
		this.numberProcess = numberProcess;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getApplicantsName() {
		return applicantsName;
	}

	public void setApplicantsName(String applicantsName) {
		this.applicantsName = applicantsName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
