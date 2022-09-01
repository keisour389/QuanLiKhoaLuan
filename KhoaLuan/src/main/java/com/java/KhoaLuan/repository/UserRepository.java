package com.java.KhoaLuan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.enums.UserRole;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	
	List<User> findAllByRole(UserRole userRole);
}
