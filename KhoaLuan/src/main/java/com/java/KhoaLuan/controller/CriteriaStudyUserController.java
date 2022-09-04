package com.java.KhoaLuan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.KhoaLuan.domain.Criteria;
import com.java.KhoaLuan.domain.CriteriaStudyUser;
import com.java.KhoaLuan.service.CriteriaService;
import com.java.KhoaLuan.service.CriteriaStudyUserService;
import com.java.KhoaLuan.service.UserService;

@Controller
public class CriteriaStudyUserController {
	
	private final CriteriaService criteriaService;
	
	private final UserService userService;
	
	private final CriteriaStudyUserService criteriaStudyUserService;
	
	public CriteriaStudyUserController(CriteriaService criteriaService,
			UserService userService, CriteriaStudyUserService criteriaStudyUserService) {
		this.criteriaService = criteriaService;
		this.userService = userService;
		this.criteriaStudyUserService = criteriaStudyUserService;
	}
	
	@GetMapping("/mark")
	public String mark(Model model, HttpServletRequest request) {
		List<Criteria> criterias = criteriaService.getAll();
		model.addAttribute("studyId", request.getParameter("studyId"));
		model.addAttribute("thesisDefenseId", request.getParameter("thesisDefenseId"));
		model.addAttribute("thesisDefenseStatus", request.getParameter("thesisDefenseStatus"));
		model.addAttribute("criterias", criterias);
		return "mark";
	}
	
	@PostMapping("/mark")
	public String mark(@ModelAttribute(value="studyId") String studyId,
			HttpServletRequest request, Authentication authetication) {
		List<Criteria> criterias = criteriaService.getAll();
		List<CriteriaStudyUser> criteriaStudyUsers = new ArrayList<CriteriaStudyUser>();
		for (Criteria criteria : criterias) {
			Object scoreObject = request.getParameter(criteria.getName().toString());
			if (Objects.nonNull(scoreObject)) {
				CriteriaStudyUser criteriaStudyUser = new CriteriaStudyUser();
				String score = scoreObject.toString();
				criteriaStudyUser.setCriteriaId(criteria.getId());
				criteriaStudyUser.setStudyId(Long.parseLong(studyId.toString()));
				Long userId = userService.findOneByEmail(authetication.getName()).get().getId();
				criteriaStudyUser.setUserId(userId);
				criteriaStudyUser.setScore(Double.parseDouble(score));
				criteriaStudyUsers.add(criteriaStudyUser);
			}

		}
		Iterable<CriteriaStudyUser> iterable = criteriaStudyUsers;
		criteriaStudyUserService.saveAll(iterable);

		return "redirect:/manage-thesis-defense";
	}
}
