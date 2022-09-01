package com.java.KhoaLuan.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.KhoaLuan.config.Constant;
import com.java.KhoaLuan.domain.Study;
import com.java.KhoaLuan.domain.ThesisDefense;
import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.enums.UserRole;
import com.java.KhoaLuan.service.StudyService;
import com.java.KhoaLuan.service.ThesisDefenseService;
import com.java.KhoaLuan.service.UserService;

@Controller
public class StudyController {
	
	private final UserService userService;
	
	private final StudyService studyService;
	
	private final ThesisDefenseService thesisDefenseService;
	
	public StudyController(UserService userService, StudyService studyService,
			ThesisDefenseService thesisDefenseService) {
		this.userService = userService;
		this.studyService = studyService;
		this.thesisDefenseService = thesisDefenseService;
	}
	
	@GetMapping("/create-study")
	public String createStudy(Model model) {
		List<ThesisDefense> thesisDefenses = thesisDefenseService.findAll();
		thesisDefenses = thesisDefenses
			.stream()
			.filter(value -> value.getStudy().size() < 5)
			.collect(Collectors.toList());
		model.addAttribute("thesisDefenses", thesisDefenses);
		model.addAttribute("study", new Study());
		return "createStudy";
	}

	@PostMapping("/create-study")
	public String createStudy(@ModelAttribute(value="study") Study study,
			@ModelAttribute(value="studentsList") String studentsList,
			@ModelAttribute(value="teachersList") String teachersList,
			@ModelAttribute(value="thesisDefenseId") String thesisDefense,
			Authentication authentication, Model model,
			HttpServletRequest request) {
		Set<User> usersSet = new HashSet<User>();
		// Check students user of list
		String[] studentsEmailList = studentsList.split(Constant.EMAIL_SPLITTING_CHAR);
		for (String email : studentsEmailList) {
			System.out.println("Thesis defense: " + request.getParameter("thesisDefenseId"));
			Optional<User> user = userService.findOneByEmail(email);
			if (user.isEmpty() || user.get().getRole() != UserRole.ROLE_STUDENT) {
				model.addAttribute(Constant.ERR_MSG_KEY,
						String.format(Constant.STUDENT_EMAIL_IS_NOT_EXIST, email));
				return "createStudy";
			}
			usersSet.add(user.get());
		}
		
		// Check teachers user of list
		String[] teachersEmailList = teachersList.split(Constant.EMAIL_SPLITTING_CHAR);
		if (teachersEmailList.length > 2) {
			model.addAttribute(Constant.ERR_MSG_KEY,
					String.format( Constant.TEACHER_NUMBER_EXCEEDED_LIMITATION, 2));
			return "createStudy";
		}
		for (String email : teachersEmailList) {
			Optional<User> user = userService.findOneByEmail(email);
			if (user.isEmpty() || user.get().getRole() != UserRole.ROLE_TEACHER) {
				model.addAttribute(Constant.ERR_MSG_KEY,
						String.format(Constant.TEACHER_EMAIL_IS_NOT_EXIST, email));
				return "createStudy";
			}
			usersSet.add(user.get());
		}
		
		// Create study
		study.setUsers(usersSet);
		study.setCreatedBy(getUserLogin(authentication).get());
		study.setThesisDefense(
				thesisDefenseService
				.findById(Long.parseLong(request.getParameter("thesisDefenseId")))
				.get());
		studyService.createStudy(study);
		model.addAttribute(Constant.STUDY_CREATED_SUCCESSFULLY_KEY, Constant.STUDY_CREATED_SUCCESSFULLY_VALUE);
		return "createStudy";
	}
	
	private Optional<User> getUserLogin(Authentication authentication) {
		if (Objects.isNull(authentication)) {
			return userService.findOneById(Constant.DEFAULT_USER_ID);
		}
		return userService.findOneByEmail(authentication.getName());
	}
}
