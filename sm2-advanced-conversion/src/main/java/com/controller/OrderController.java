package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	// url: findOrder?userId=&orderId=
	@RequestMapping("/findOrder/{userId}/{orderId}")   // {url模板变量}
	public String findOrder(@PathVariable(value="userId")String userId, 
			@PathVariable(value="orderId") String orderId){
		
		System.out.println(userId + ":::" + orderId);
		
		return "index";
	}

}
