package com.java.KhoaLuan.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.java.KhoaLuan.domain.Criteria;
import com.java.KhoaLuan.repository.CriteriaRepository;
import com.java.KhoaLuan.service.CriteriaService;

@Service
@Transactional
public class CriteriaServiceImpl implements CriteriaService {
	
	private final CriteriaRepository criteriaRepository;
	
	public CriteriaServiceImpl(CriteriaRepository criteriaRepository) {
		this.criteriaRepository = criteriaRepository;
	}

	@Override
	public List<Criteria> getAll() {
		return criteriaRepository.findAll();
	}

}
