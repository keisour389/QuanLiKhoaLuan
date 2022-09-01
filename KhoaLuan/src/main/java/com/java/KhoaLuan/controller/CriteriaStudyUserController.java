package com.java.KhoaLuan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.KhoaLuan.domain.Criteria;
import com.java.KhoaLuan.service.CriteriaService;

@Controller
public class CriteriaStudyUserController {
	
	private final CriteriaService criteriaService;
	
	public CriteriaStudyUserController(CriteriaService criteriaService) {
		this.criteriaService = criteriaService;
	}
	
	@GetMapping("/mark")
	public String mark(Model model) {
		List<Criteria> criterias = criteriaService.getAll();
		model.addAttribute("criterias", criterias);
		return "mark";
	}
}
