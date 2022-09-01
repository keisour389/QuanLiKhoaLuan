package com.java.KhoaLuan.service.impl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.java.KhoaLuan.domain.ThesisDefense;
import com.java.KhoaLuan.enums.ThesisDefenseStatus;
import com.java.KhoaLuan.repository.ThesisDefenseRepository;
import com.java.KhoaLuan.service.ThesisDefenseService;

@Service
@Transactional
public class ThesisDefenseImpl implements ThesisDefenseService {
	
	private final ThesisDefenseRepository thesisDefenseRepository;
	
	public ThesisDefenseImpl(ThesisDefenseRepository thesisDefenseRepository) {
		this.thesisDefenseRepository = thesisDefenseRepository;
	}
	
	public ThesisDefense createThesisDefense(ThesisDefense thesisDefense) {
		thesisDefense.setStatus(ThesisDefenseStatus.IN_PROGESS);
		return thesisDefenseRepository.save(thesisDefense);
	}

	@Override
	public List<ThesisDefense> findThesisDefenseByEmail(String email) {
		return thesisDefenseRepository.findThesisDefenseByEmail(email);
	}

	@Override
	public List<ThesisDefense> findAllByStatus(ThesisDefenseStatus thesisDefenseStatus) {
		return thesisDefenseRepository.findAllByStatus(thesisDefenseStatus);
	}
	
	@Override
	public List<ThesisDefense> findAll() {
		return thesisDefenseRepository.findAll();
	}

	@Override
	public Optional<ThesisDefense> findById(Long id) {
		return thesisDefenseRepository.findById(id);
	}

}
