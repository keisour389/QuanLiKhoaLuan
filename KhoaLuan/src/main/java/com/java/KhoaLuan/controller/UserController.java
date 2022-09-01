package com.java.KhoaLuan.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.KhoaLuan.config.Constant;
import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute(value="user") User user, Model model) {
		Optional<User> userOpt = userService.findOneByEmail(user.getEmail());
		if(userOpt.isPresent()) {
			model.addAttribute(Constant.ERR_MSG_KEY, Constant.EMAIL_ALREADY_USED_ERROR);
		} else {
			String passwordPlainText = userService.createUser(user);
			model.addAttribute(Constant.USER_PASSWORD_PLAIN_TEXT, passwordPlainText);
			model.addAttribute(Constant.USER_CREATED_DATE,  Date.from(user.getCreatedDate()));
			model.addAttribute(Constant.USER_DATA_AFTER_CREATING_KEY, user);
		}
		System.out.println("Email: " + user.getEmail());
		System.out.println("Role: " + user.getRole());
		System.out.println("Date: " + user.getCreatedDate());
		
		return "register";
	}
	
	@GetMapping("/change-password")
	public String changePassword(Model model) {
		model.addAttribute("newPassword", String.class);
		model.addAttribute("newConfirmPassword", String.class);
		return "changePassword";
	}
	
	@PostMapping("/change-password")
	public String changePassword(@ModelAttribute(value="newPassword") String newPassword,
			@ModelAttribute(value="newConfirmPassword") String newConfirmPassword, Model model,
			Authentication authentication) {
		String email = authentication.getName();
		System.out.println("Authentication: " + authentication.getName());
		System.out.println("New password: " + newPassword);
		Optional<User> userOpt = userService.findOneByEmail(email);
		System.out.println("Email: " + email);
		if (userOpt.isEmpty()) {
			model.addAttribute(Constant.ERR_MSG_KEY, Constant.EMAIL_IS_NOT_EXIST);
			return "changePassword";
		} else if (!newPassword.equals(newConfirmPassword)) {
			model.addAttribute(Constant.ERR_MSG_KEY, Constant.PASSWORD_IS_NOT_MATCH);
			return "changePassword";
		} else {
			User user = userOpt.get();
			userService.changeUserPassword(user, newPassword);
			model.addAttribute(Constant.USER_CHANGE_PASSWORD_KEY, Constant.USER_CHANGE_PASSWORD_VALUE);
		}
		// Clear params value in URL
		model.asMap().clear();
		return "redirect:/";
	}
}
