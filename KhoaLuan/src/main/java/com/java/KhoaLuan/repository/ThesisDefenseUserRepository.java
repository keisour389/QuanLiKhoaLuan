package com.java.KhoaLuan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.KhoaLuan.domain.ThesisDefenseUser;
import com.java.KhoaLuan.domain.ThesisDefenseUserId;

public interface ThesisDefenseUserRepository extends JpaRepository<ThesisDefenseUser, ThesisDefenseUserId> {

}
