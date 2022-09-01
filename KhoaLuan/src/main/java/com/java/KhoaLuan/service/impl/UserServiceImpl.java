package com.java.KhoaLuan.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.KhoaLuan.config.Constant;
import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.enums.UserRole;
import com.java.KhoaLuan.repository.UserRepository;
import com.java.KhoaLuan.service.UserService;
import com.java.KhoaLuan.utils.AccountUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public String createUser(User user) {
		String passwordPlainText = (AccountUtil.passwordGenerator(Constant.USER_PASSWORD_LEN));
		user.setPassword(new BCryptPasswordEncoder()
				.encode(passwordPlainText));
		userRepository.save(user);
		return passwordPlainText;
	}

	@Override
	public Optional<User> findOneByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void changeUserPassword(User user, String passwordPlainText) {
		user.setPassword(new BCryptPasswordEncoder()
				.encode(passwordPlainText));
		recordUserChange(user);
		userRepository.save(user);		
	}
	
	private void recordUserChange(User user) {
		user.setLastModifiedBy(user.getId());
		user.setLastModifiedDate(Instant.now());
	}

	@Override
	public Optional<User> findOneById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAllByRole(UserRole userRole) {
		return userRepository.findAllByRole(userRole);
	}

}
