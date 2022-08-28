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
	
	private final UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/test")
	public String index() {
		return "index";
	}

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		System.out.println("------------");
		ModelAndView mav = new ModelAndView("home");
		List<User> userList = userService.getAllUsers();
		System.out.println(userList.get(0).getEmail());
		mav.addObject("test", userList.get(0).getEmail());
		mav.addObject("userList", userList);
		return mav;
	}
}
