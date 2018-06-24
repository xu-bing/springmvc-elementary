package com.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class DefaultExceptionHandlerController {
	@ExceptionHandler
	public ModelAndView handleException(Exception ex){
		 return new ModelAndView("error", "ex", ex);
	}
}
