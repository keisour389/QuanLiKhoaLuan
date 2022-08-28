package com.java.KhoaLuan.service;

import java.util.List;

import com.java.KhoaLuan.domain.User;

public interface UserService {
	List<User> getAllUsers();

	void createUser(User user);
}
