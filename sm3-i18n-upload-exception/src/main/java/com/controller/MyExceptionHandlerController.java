package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常处理器
 * @author boode
 *
 */
public class MyExceptionHandlerController implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		String result = "error";
		
		if (ex instanceof NullPointerException){
			result = "null-pointer";
		}
		
		return new ModelAndView(result, "ex", ex);
	}

}
