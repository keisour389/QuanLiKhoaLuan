package com.java.KhoaLuan.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.java.KhoaLuan.domain.Study;
import com.java.KhoaLuan.repository.StudyRepository;
import com.java.KhoaLuan.service.StudyService;

@Service
@Transactional
public class StudyServiceImpl implements StudyService {
	
	private final StudyRepository studyRepository;

	public StudyServiceImpl(StudyRepository studyRepository) {
		this.studyRepository = studyRepository;
	}
	
	@Override
	public void createStudy(Study study) {
		studyRepository.save(study);
	}

	@Override
	public Optional<Study> findById(Long id) {
		return studyRepository.findById(id);
	}

}
