package com.java.KhoaLuan.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.java.KhoaLuan.domain.CriteriaStudyUser;
import com.java.KhoaLuan.repository.CriteriaStudyUserRepository;
import com.java.KhoaLuan.service.CriteriaStudyUserService;

@Service
@Transactional
public class CriteriaStudyUserServiceImpl implements CriteriaStudyUserService {
	
	private final CriteriaStudyUserRepository criteriaStudyUserRepository;
	
	public CriteriaStudyUserServiceImpl(CriteriaStudyUserRepository criteriaStudyUserRepository) {
		this.criteriaStudyUserRepository = criteriaStudyUserRepository;
	}

	@Override
	public void saveAll(Iterable<CriteriaStudyUser> iterable) {
		criteriaStudyUserRepository.saveAll(iterable);	
	}

	@Override
	public List<CriteriaStudyUser> findByStudyIdIn(List<Long> studyIds) {
		return criteriaStudyUserRepository.findByStudyIdIn(studyIds);
	}

}
