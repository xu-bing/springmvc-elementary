package com.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {

        // 创建数据模型视图对象
        ModelAndView mv = new ModelAndView();

        // 添加结果数据
        mv.addObject("message", "hello world");

        // 设置逻辑视图名称
        mv.setViewName("/WEB-INF/jsp/HelloWorld.jsp");

        return mv;
    }
}
