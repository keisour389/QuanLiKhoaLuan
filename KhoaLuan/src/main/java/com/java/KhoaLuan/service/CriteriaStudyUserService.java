package com.java.KhoaLuan.service;

import java.util.List;

import com.java.KhoaLuan.domain.CriteriaStudyUser;

public interface CriteriaStudyUserService {
	void saveAll(Iterable<CriteriaStudyUser> iterable);
	
	List<CriteriaStudyUser> findByStudyIdIn(List<Long> studyIds);
}
