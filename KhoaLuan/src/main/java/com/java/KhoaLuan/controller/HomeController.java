package com.java.KhoaLuan.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/test")
	public String index() {
		return "index";
	}

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
}
