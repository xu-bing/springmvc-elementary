package com.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private String username;
	private Integer age;
	
	private Address address;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthdate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
	
	
}
