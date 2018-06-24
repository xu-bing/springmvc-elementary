package com.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;


public class User {
	@Length(min=1, max=10, message="用户姓名必须在{min}到{max}之间") 
	private String username;
	
	//@NotNull(message="年龄不能为空")
	@NotNull(message="{register.validation.age.notnull}")
	@Range(min=1, max=130, message="年龄必须在{min}到{max}之间")
	private Integer age;
	
	@NotBlank(message="密码不能为空")
	private String password;
	
	@NotBlank(message="邮箱不能为空")
	@Email(message="邮箱格式不正确")
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
