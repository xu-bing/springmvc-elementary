package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.User;

@Controller
public class UserController {
	
	@RequestMapping("/toRegister")
	public String toRegister(){
		return "register";
	}
	
	/*@RequestMapping("/{toPage}")
	public String toPage(@PathVariable(value="toPage") String toPage){
		
		// ���ض�̬ҳ��
		return toPage;
	}*/
	
	/*@RequestMapping("/addUser")
	public String addUser(User user){
		System.out.println(user.getUsername() + ":::" + user.getAge());
		
		System.out.println(user.getAddress().getCity());
		
		System.out.println(user.getBirthdate());
		
		return "index";
	}*/	
	
	/*// ����@ModelAttribute
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute(value="user1") User user){
		System.out.println(user.getUsername());
		
		return "index";
	}*/

	// -----------------------------------------------------------------------------------------------------------
	// ����@RequestParam (1) : ������ֶ�������ղ��������Ʋ�һ�µ�����
	/*@RequestMapping("/addUser")
	public String addUser(@RequestParam(value="username") String uname){
		System.out.println(uname);
		
		return "index";
	}*/

	// ����@RequestParam (2) : ����������ֵΪ�մ���
	@RequestMapping("/addUser")
	//public String addUser(@RequestParam(value="username", required=true, defaultValue="no name") String username){
	// => no name
	// public String addUser(@RequestParam(value="username", required=true) String username){
	// => ��
	// public String addUser(@RequestParam(value="uname", required=true) String username){
	// => HTTP Status 400 - Required String parameter 'uname' is not present
	public String addUser(@RequestParam(value="uname", required=false) String username){
	// => null
		System.out.println(username);
		
		return "index";
	}
	

	// ����@RequestParam (3) : ת��Ϊ����
	// �����������ת��Ϊ����
	/*@RequestMapping("/addUser")
	public String addUser(@RequestParam(value="telephone") String[] telephones){
		System.out.println(telephones[0] + ":::" + telephones[1]);
		
		return "index";
	}*/
	
	// �����������ת��Ϊ�б�
	/*@RequestMapping("/addUser")
	public String addUser(@RequestParam(value="telephone") List telephoneList){
		System.out.println(telephoneList.get(0) + ":::" + telephoneList.get(1) );
		
		return "index";
	}*/
	
	
}
