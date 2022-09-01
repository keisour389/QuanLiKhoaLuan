package com.java.KhoaLuan.service;

import java.util.List;
import java.util.Optional;

import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.enums.UserRole;

public interface UserService {
	List<User> getAllUsers();

	String createUser(User user);
	
	Optional<User> findOneByEmail(String email);
	
	List<User> findAllByRole(UserRole userRole);
	
	Optional<User> findOneById(Long id);
	
	void changeUserPassword(User user, String password);
}
