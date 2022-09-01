package com.java.KhoaLuan.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.java.KhoaLuan.domain.ThesisDefenseUser;
import com.java.KhoaLuan.repository.ThesisDefenseRepository;
import com.java.KhoaLuan.repository.ThesisDefenseUserRepository;
import com.java.KhoaLuan.service.ThesisDefenseUserService;

@Service
@Transactional
public class ThesisDefenseUserServiceImpl implements ThesisDefenseUserService {
	
	private final ThesisDefenseUserRepository thesisDefenseUserRepository;
	
	public ThesisDefenseUserServiceImpl(ThesisDefenseUserRepository thesisDefenseUserRepository) {
		this.thesisDefenseUserRepository = thesisDefenseUserRepository;
	}

	@Override
	public void createThesisDefenseUsers(Iterable<ThesisDefenseUser> thesisDefenseUsers) {
		thesisDefenseUserRepository.saveAll(thesisDefenseUsers);
		
	}

}
