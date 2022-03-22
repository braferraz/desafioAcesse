package com.acesse.desafio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Process {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "number_process")
	private Long numberProcess;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "additional")
	private String additional;
	
	@Column(name = "process_date")
	private Date processDate;
	
	@Column(name = "creation_date")
	private String creationDate;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "deleted_by")
	private String deletedBy;
	
	public Process() {
		
	}
	
	public Process(Long numberProcess, String subject, String name, String phone,
			String email, String zipCode, String city, String district, String street, int number,
			String additional, Date processDate, String creationDate, boolean active, String deletedBy) {
		this.numberProcess = numberProcess;
		this.subject = subject;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.zipCode = zipCode;
		this.city = city;
		this.district = district;
		this.street = street;
		this.number = number;
		this.additional = additional;
		this.processDate = processDate;
		this.creationDate = creationDate;
		this.active = active;
		this.deletedBy = deletedBy;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
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

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

}
