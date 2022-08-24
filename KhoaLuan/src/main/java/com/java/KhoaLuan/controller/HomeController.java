package com.java.KhoaLuan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.repository.UserRepository;
import com.java.KhoaLuan.service.UserService;
import com.java.KhoaLuan.service.impl.UserServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	private final UserRepository userRepository;
	
	public HomeController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping("/test")
	public String index() {
		return "index";
	}

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		System.out.println("------------");
		ModelAndView mav = new ModelAndView("home");
		//mav.addObject("userList", userList);
		return mav;
	}
}
