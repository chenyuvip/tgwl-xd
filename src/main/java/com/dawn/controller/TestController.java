package com.dawn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController
{
	@RequestMapping("/test")
	public ModelAndView test(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("layout/main");
		
		
		return mv;
	}
}
