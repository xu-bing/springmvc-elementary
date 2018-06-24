package com.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;


public class User {
	@Length(min=1, max=10, message="�û�����������{min}��{max}֮��") 
	private String username;
	
	//@NotNull(message="���䲻��Ϊ��")
	@NotNull(message="{register.validation.age.notnull}")
	@Range(min=1, max=130, message="���������{min}��{max}֮��")
	private Integer age;
	
	@NotBlank(message="���벻��Ϊ��")
	private String password;
	
	@NotBlank(message="���䲻��Ϊ��")
	@Email(message="�����ʽ����ȷ")
	private String mail;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
