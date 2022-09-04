package com.java.KhoaLuan.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.java.KhoaLuan.config.Constant;
import com.java.KhoaLuan.domain.Criteria;
import com.java.KhoaLuan.domain.CriteriaStudyUser;
import com.java.KhoaLuan.domain.Study;
import com.java.KhoaLuan.domain.ThesisDefense;
import com.java.KhoaLuan.domain.ThesisDefenseUser;
import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.enums.ThesisDefenseRole;
import com.java.KhoaLuan.enums.UserRole;
import com.java.KhoaLuan.service.CriteriaService;
import com.java.KhoaLuan.service.CriteriaStudyUserService;
import com.java.KhoaLuan.service.StudyService;
import com.java.KhoaLuan.service.ThesisDefenseService;
import com.java.KhoaLuan.service.ThesisDefenseUserService;
import com.java.KhoaLuan.service.UserService;
import com.java.KhoaLuan.utils.SendEmailUtil;

@Controller
public class ThesisDefenseController {
	
	private final ThesisDefenseService thesisDefenseService;
	
	private final ThesisDefenseUserService thesisDefenseUserService;
	
	private final UserService userService;
	
	private final CriteriaStudyUserService criteriaStudyUserService;
	
	private final StudyService studyService;
	
	private final CriteriaService criteriaService;
	
	public ThesisDefenseController (ThesisDefenseService thesisDefenseService,
			ThesisDefenseUserService thesisDefenseUserService,
			UserService userService, CriteriaStudyUserService criteriaStudyUserService,
			StudyService studyService, CriteriaService criteriaService) {
		this.thesisDefenseService = thesisDefenseService;
		this.thesisDefenseUserService = thesisDefenseUserService;
		this.userService = userService;
		this.criteriaStudyUserService = criteriaStudyUserService;
		this.studyService = studyService;
		this.criteriaService = criteriaService;
	}
	
	@GetMapping("/create-thesis-defense")
	public String createThesisDefense() {
		return "thesisDefense";
	}
	
	@PostMapping("/create-thesis-defense")
	public String createThesisDefense(@ModelAttribute(value="manager") String manager,
			@ModelAttribute(value="secretary") String secretary,
			@ModelAttribute(value="counterAgrument") String counterAgrument,
			@ModelAttribute(value="member1") String member1,
			@ModelAttribute(value="member2") String member2,
			Model model, Authentication authentication) {
		// Check duplicated email
		String[] modelUsers = {manager, secretary, counterAgrument, member1, member2};
		List<String> usersList = Arrays
				.stream(modelUsers)
				.filter(value -> value.length() != 0)
				.collect(Collectors.toList());
		Set<String> usersSet = new HashSet<>(usersList);
		
		// Set will be filler duplicated email
		if (usersSet.size() != usersList.size()) {
			model.addAttribute(Constant.ERR_MSG_KEY, Constant.EMAIL_IS_DUPLICATED);
			return "thesisDefense";
		}
		
		List<ThesisDefenseUser> thesisDefenseUsers = new ArrayList<>();
		
		// Check mandatory mails is null
		List<User> users = userService.findAllByRole(UserRole.ROLE_TEACHER);
		List<String> userEmail =  users
				.stream()
				.map(user -> user.getEmail())
				.collect(Collectors.toList());
		
		// Manager
		if (!userEmail.contains(manager)) {
			model.addAttribute(Constant.ERR_MSG_KEY,
					String.format(Constant.EMAIL_IS_NOT_EXIST_TO_REGISTER_THESIS_DEFENSE, manager));
			return "thesisDefense";
		} else {
			thesisDefenseUsers.add(generateThesisDefenseUser(
					filerUserIdByEmail(users, manager).get(),
					ThesisDefenseRole.ROLE_MANAGER));
		}
		
		// Secretary
		if (!userEmail.contains(secretary)) {
			model.addAttribute(Constant.ERR_MSG_KEY,
					String.format(Constant.EMAIL_IS_NOT_EXIST_TO_REGISTER_THESIS_DEFENSE, secretary));
			return "thesisDefense";
		} else {
			thesisDefenseUsers.add(generateThesisDefenseUser(
					filerUserIdByEmail(users, secretary).get(),
					ThesisDefenseRole.ROLE_SECRETARY));
		}
		
		// Counter Agrument
		if (!userEmail.contains(counterAgrument)) {
			model.addAttribute(Constant.ERR_MSG_KEY,
					String.format(Constant.EMAIL_IS_NOT_EXIST_TO_REGISTER_THESIS_DEFENSE, counterAgrument));
			return "thesisDefense";
		} else {
			thesisDefenseUsers.add(generateThesisDefenseUser(
					filerUserIdByEmail(users, counterAgrument).get(),
					ThesisDefenseRole.ROLE_COUNTER_ARGUMENT));
		}
		
		// Member 1
		if (member1.length() > 0) {
			if (userEmail.contains(member1)) {
				thesisDefenseUsers.add(generateThesisDefenseUser(
						filerUserIdByEmail(users, member1).get(),
						ThesisDefenseRole.ROLE_MEMBER));
			} else {
				model.addAttribute(Constant.ERR_MSG_KEY,
						String.format(Constant.EMAIL_IS_NOT_EXIST_TO_REGISTER_THESIS_DEFENSE, member1));
				return "thesisDefense";
			}
		}
		
		// Member 2
		if (member2.length() > 0) {
			if (userEmail.contains(member2)) {
				thesisDefenseUsers.add(generateThesisDefenseUser(
						filerUserIdByEmail(users, member2).get(),
						ThesisDefenseRole.ROLE_MEMBER));
			} else {
				model.addAttribute(Constant.ERR_MSG_KEY,
						String.format(Constant.EMAIL_IS_NOT_EXIST_TO_REGISTER_THESIS_DEFENSE, member2));
				return "thesisDefense";
			}
		}
		
		// Create thesis defense first
		ThesisDefense thesisDefense = new ThesisDefense();
		thesisDefense.setCreatedBy(getUserLogin(authentication).get());
		ThesisDefense newThesisDefense =  thesisDefenseService.createThesisDefense(thesisDefense);
//		newThesisDefense.getStatus().toString().equals("IN_PROGRESS");
		// Create assignment of thesis defense
		thesisDefenseUsers.forEach(value -> value.setThesisDefenseId(newThesisDefense.getId()));
		Iterable<ThesisDefenseUser> iterable = thesisDefenseUsers;
		thesisDefenseUserService.createThesisDefenseUsers(iterable);
		model.addAttribute(Constant.THESIS_DEFENSE_CREATED_SUCCESSFULLY_KEY,
				Constant.THESIS_DEFENSE_CREATED_SUCCESSFULLY_VALUE);
		return "thesisDefense";
	}
	
	@GetMapping("/manage-thesis-defense")
	public String manageThesisDefense(Model model,
			Authentication authentication) {
		if (Objects.nonNull(authentication.getName())) {
			Optional<User> userOpt = userService.findOneByEmail(authentication.getName());
			List<ThesisDefense> thesisDefenses = null;
			if (userOpt.get().getRole().equals(UserRole.ROLE_MINISTRY)) {
				thesisDefenses =
						thesisDefenseService.findAll();
			} else {
				thesisDefenses =
						thesisDefenseService.findThesisDefenseByEmail(authentication.getName());
			}
			
			if (!thesisDefenses.isEmpty()) {
				model.addAttribute(Constant.THESIS_DEFENSE_LIST, thesisDefenses);
				return "manageThesisDefense";
			} else {
				model.addAttribute(Constant.ERR_MSG_KEY, Constant.THESIS_DEFENSE_EMPTY_LIST);
				return "manageThesisDefense";
			}
		}		
		return "manageThesisDefense";
	}
	
	@PostMapping("/manage-thesis-defense")
	public String mark(
			@ModelAttribute(value="studyId") String studyId,
			@ModelAttribute(value="thesisDefenseId") String thesisDefenseId,
			@ModelAttribute(value="thesisDefenseStatus") String thesisDefenseStatus) {
		return "redirect:/mark";
	}
	
	@PostMapping("/mark-done")
	public String markDone(Model model, Authentication authentication,
			@ModelAttribute(value="thesisDefenseId") String thesisDefenseId) {
		Optional<ThesisDefense> thesisDefenseOpt = 
				thesisDefenseService.findById(Long.parseLong(thesisDefenseId));
		List<Long> studyIds = thesisDefenseOpt.get().getStudy()
				.stream().map(value -> value.getId()).collect(Collectors.toList());
		List<CriteriaStudyUser> criteriaStudyUsers = criteriaStudyUserService.findByStudyIdIn(studyIds);
		Set<Long> studyIdSet = criteriaStudyUsers.stream()
				.map(value -> value.getStudyId()).collect(Collectors.toSet());
		thesisDefenseService.markDone(Long.parseLong(thesisDefenseId), authentication.getName());
		for (Long studyId : studyIdSet) {
			List<String> criterias = new ArrayList<String>();
			List<Double> scores = new ArrayList<Double>();
			List<String> emails = new ArrayList<String>();
			List<CriteriaStudyUser> cSTStudy = criteriaStudyUsers.stream()
					.filter(value -> value.getStudyId() == studyId)
					.collect(Collectors.toList());
			for (Criteria c : criteriaService.getAll()) {
				List<Double> scorceOfCriteria = cSTStudy.stream()
						.filter(value -> value.getCriteriaId() == c.getId())
						.map(value -> value.getScore()).collect(Collectors.toList());
				Double avetageScorce = 0D;
				for (Double s : scorceOfCriteria) {
					avetageScorce += s;
				}
				avetageScorce = avetageScorce / scorceOfCriteria.size();
				criterias.add(c.getName().toString());
				scores.add(avetageScorce);		
			}
			Optional<Study> studyOpt = studyService.findById(studyId);
			emails = studyOpt.get().getUsers()
					.stream()
					.filter(value -> value.getRole().equals(UserRole.ROLE_STUDENT))
					.map(value -> value.getEmail())
					.collect(Collectors.toList());
			sendEmailToStudent(emails, criterias, scores);
		}
		model.addAttribute(Constant.MAKE_DONE_SUCCESSFULLY_KEY,
				String.format( Constant.MAKE_DONE_SUCCESSFULLY_VALUE, thesisDefenseId));
		return "redirect:/manage-thesis-defense";
	}
	
	private Optional<Long> filerUserIdByEmail(List<User> users, String email) {
		return users
				.stream()
				.filter(value -> value.getEmail().equals(email))
				.map(id -> id.getId())
				.findFirst();
	}
	
	private ThesisDefenseUser generateThesisDefenseUser(Long userId, ThesisDefenseRole role) {
		ThesisDefenseUser thesisDefenseUser = new ThesisDefenseUser();
		thesisDefenseUser.setUserId(userId);
		thesisDefenseUser.setRole(role);
		return thesisDefenseUser;
	}
	
	private Optional<User> getUserLogin(Authentication authentication) {
		if (Objects.isNull(authentication)) {
			return userService.findOneById(Constant.DEFAULT_USER_ID);
		}
		return userService.findOneByEmail(authentication.getName());
	}
	
	private void sendEmailToStudent(List<String> emails, List<String> criterias, List<Double> scores) {
		String template = "Điểm trung bình khóa luận của bạn. ";
		for (int i = 0; i < criterias.size(); i++) {
			template = template + "Tiêu chí " + criterias.get(i) + ": " + scores.get(i) + " điểm. ";
		}
		for (String email : emails) {
			SendEmailUtil.sendEmail(Constant.SUBJECT, template, email);
		}
	}
}
