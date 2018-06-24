package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

@Controller
@SessionAttributes("username")	// ���Ʊ�����model�еĲ�������һ��
public class LoginController {
	
	/*@RequestMapping("/toLogin")
	public ModelAndView toLogin(){
		
		return new ModelAndView("login", "message", "hello");
	}*/
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		
		return "login"; 
	} 
	
	@RequestMapping("/toIndex")
	public String toIndex(){
		
		return "index";
	}
	
	/**
	 * 
	 * @param username ���ڽ���ǰ̨�û� ����
	 * @param password ���ڽ���ǰ̨����
	 * @param model ���ڷ�����֤���
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	// public String login(String username, String password, Model model){
	//public String login(String username, String password, HttpServletRequest request){
	public String login(String username, String password, ModelMap model){
		// test
		// 1. ǰ̨����
		System.out.println(username + ":::" + password);
		
		// 2. ��֤ 		
		// 3. ���ؽ����ͼ
		if (username.equals("tom") && password.equals("123")){
			
			//model.addAttribute("username", username);
			
			// session
			// (1) ͨ��request���
			//HttpSession session = request.getSession();
			//session.setAttribute("username", username);
			
			// (2) ͨ��springmvc��WebUtils���߰� + request
			// WebUtils.setSessionAttribute(request, "username", username);
			
			// (3) @SessionAttributes + model
			model.addAttribute("username", username);
			
			return "welcome";
		} else {
			model.addAttribute("message", "�������������");
			return "login";
		}
		
	}	// login
}
