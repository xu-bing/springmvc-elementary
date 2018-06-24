package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.User;

@Controller
public class UserController {
	
	@RequestMapping("/{toPage}")
	public String toPage(@PathVariable(value="toPage") String toPage){
		return toPage;
	}
	
	@RequestMapping("/addUser")
	public String addUser(@Validated User user, BindingResult bindingResult){
		System.out.println(user.getMail());
		
		// ����bindingResult���Ƿ��д��󣬷��ز�ͬ���߼���ͼ
		if (bindingResult.hasErrors()){
			
			return "register";
		} else {
			return "index";
		}
		
	}
	
	// ����json
	@RequestMapping("/findUser")
	@ResponseBody
	public User findUser(){
		
		User user = new User();
		user.setUsername("tom");
		user.setAge(21);
		
		return user;
	}
}	
