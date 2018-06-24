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
@SessionAttributes("username")	// 名称必须与model中的参数名称一致
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
	 * @param username 用于接收前台用户 姓名
	 * @param password 用于接收前台密码
	 * @param model 用于返回验证结果
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	// public String login(String username, String password, Model model){
	//public String login(String username, String password, HttpServletRequest request){
	public String login(String username, String password, ModelMap model){
		// test
		// 1. 前台参数
		System.out.println(username + ":::" + password);
		
		// 2. 验证 		
		// 3. 返回结果视图
		if (username.equals("tom") && password.equals("123")){
			
			//model.addAttribute("username", username);
			
			// session
			// (1) 通过request获得
			//HttpSession session = request.getSession();
			//session.setAttribute("username", username);
			
			// (2) 通过springmvc的WebUtils工具包 + request
			// WebUtils.setSessionAttribute(request, "username", username);
			
			// (3) @SessionAttributes + model
			model.addAttribute("username", username);
			
			return "welcome";
		} else {
			model.addAttribute("message", "姓名或密码错误");
			return "login";
		}
		
	}	// login
}
