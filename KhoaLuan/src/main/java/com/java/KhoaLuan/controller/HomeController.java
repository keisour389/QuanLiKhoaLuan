package com.java.KhoaLuan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.KhoaLuan.config.Constant;
import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.repository.UserRepository;
import com.java.KhoaLuan.service.UserService;
import com.java.KhoaLuan.service.impl.UserServiceImpl;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView homePage(HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	@GetMapping(value="/admin")
	public String adminPage(Model model, Authentication authentication){
		model.addAttribute(Constant.USER_ADMIN, authentication.getName());
		model.addAttribute(Constant.USER_LOGGED_IN, authentication.getName());
		return "home";
	}
	
	@GetMapping(value="/ministry")
	public String ministryPage(Model model, Authentication authentication){
		model.addAttribute(Constant.USER_MINISTRY, authentication.getName());
		model.addAttribute(Constant.USER_LOGGED_IN, authentication.getName());
		return "home";
	}
	
	@GetMapping(value="/teacher")
	public String teacherPage(Model model, Authentication authentication){
		model.addAttribute(Constant.USER_TEACHER, authentication.getName());
		model.addAttribute(Constant.USER_LOGGED_IN, authentication.getName());
		return "home";
	}
	
	@GetMapping(value="/student")
	public String studentPage(Model model, Authentication authentication){
		model.addAttribute(Constant.USER_STUDENT, authentication.getName());
		model.addAttribute(Constant.USER_LOGGED_IN, authentication.getName());
		return "home";
	}
}
