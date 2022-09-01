package com.java.KhoaLuan.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.java.KhoaLuan.config.Constant;
import com.java.KhoaLuan.domain.Criteria;
import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.enums.CriteriaEnum;
import com.java.KhoaLuan.enums.UserRole;
import com.java.KhoaLuan.repository.CriteriaRepository;
import com.java.KhoaLuan.repository.UserRepository;

@Component
public class DbInit {
	
	private final UserRepository userRepository;
	
	private final CriteriaRepository criteriaRepository;
	
	public DbInit(UserRepository userRepository,
			CriteriaRepository criteriaRepository) {
		this.userRepository = userRepository;
		this.criteriaRepository = criteriaRepository;
	}

	@PostConstruct
    private void postConstruct() {
		List<Criteria> criterias = criteriaRepository.findAll();
		if (criterias.size() == 0) {
			Optional<User> userOpt = userRepository.findByEmail(Constant.ADMIN_EMAIL);
			User user = new User();
			if (userOpt.isEmpty()) {
				user.setFirstName(Constant.ADMIN_FIRST_NAME);
				user.setLastName(Constant.ADMIN_LAST_NAME);
				user.setEmail(Constant.ADMIN_EMAIL);
				user.setRole(UserRole.ROLE_ADMIN);
				user.setPassword(new BCryptPasswordEncoder().encode(Constant.ADMIN_PASSWORD));
				user = userRepository.save(user);
			} else {
				user = userOpt.get();
			}
			criterias.add(new Criteria(CriteriaEnum.ATTITUDE, user));
			criterias.add(new Criteria(CriteriaEnum.SKILL, user));
			criterias.add(new Criteria(CriteriaEnum.KNOWLEDGE, user));
			
			Iterable<Criteria> iterable = criterias;
			criteriaRepository.saveAll(iterable);
		}
	}
}
