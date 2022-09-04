package com.java.KhoaLuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.KhoaLuan.domain.CriteriaStudyUser;
import com.java.KhoaLuan.domain.CriteriaStudyUserId;

public interface CriteriaStudyUserRepository extends JpaRepository<CriteriaStudyUser, CriteriaStudyUserId> {
	List<CriteriaStudyUser> findByStudyIdIn(List<Long> studyIds);

}
