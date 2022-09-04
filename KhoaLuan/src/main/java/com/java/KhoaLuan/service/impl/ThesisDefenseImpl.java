package com.java.KhoaLuan.service.impl;


import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.java.KhoaLuan.domain.ThesisDefense;
import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.enums.ThesisDefenseRole;
import com.java.KhoaLuan.enums.ThesisDefenseStatus;
import com.java.KhoaLuan.repository.ThesisDefenseRepository;
import com.java.KhoaLuan.repository.UserRepository;
import com.java.KhoaLuan.service.ThesisDefenseService;

@Service
@Transactional
public class ThesisDefenseImpl implements ThesisDefenseService {
	
	private final ThesisDefenseRepository thesisDefenseRepository;
	
	private final UserRepository userRepository;
	
	public ThesisDefenseImpl(ThesisDefenseRepository thesisDefenseRepository,
			UserRepository userRepository) {
		this.thesisDefenseRepository = thesisDefenseRepository;
		this.userRepository = userRepository;
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

	@Override
	public void markDone(Long thesisDefenseId, String userLoginEmail) {
		Optional<ThesisDefense> thesisDefenseOpt = thesisDefenseRepository.findById(thesisDefenseId);
		Optional<User> userOpt = userRepository.findByEmail(userLoginEmail);
		if (thesisDefenseOpt.isPresent() && userOpt.isPresent()) {
			ThesisDefense thesisDefense = thesisDefenseOpt.get();
			thesisDefense.setStatus(ThesisDefenseStatus.DONE);
			recordThesisDefenseChange(thesisDefense, userOpt.get());
			thesisDefenseRepository.save(thesisDefense);
		}
	}
	
	private void recordThesisDefenseChange(ThesisDefense thesisDefense, User userLogin) {
		thesisDefense.setLastModifiedBy(userLogin);
		thesisDefense.setLastModifiedDate(Instant.now());
	}
}
