package com.java.KhoaLuan.service;

import java.util.Optional;

import com.java.KhoaLuan.domain.Study;

public interface StudyService {
	void createStudy(Study study);
	
	Optional<Study> findById(Long id);
}
