package com.java.KhoaLuan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.KhoaLuan.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
