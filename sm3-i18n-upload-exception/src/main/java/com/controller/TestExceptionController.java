package com.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//public class TestExceptionController {
public class TestExceptionController extends DefaultExceptionHandlerController{
	@RequestMapping("testException")
	public String testException(){
		
		Date d = null;
		d.getYear();
		
		return "index";
	}
}
