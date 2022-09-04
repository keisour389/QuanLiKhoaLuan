package com.java.KhoaLuan.service;

import java.util.List;
import java.util.Optional;

import com.java.KhoaLuan.domain.ThesisDefense;
import com.java.KhoaLuan.domain.User;
import com.java.KhoaLuan.enums.ThesisDefenseStatus;

public interface ThesisDefenseService {
	ThesisDefense createThesisDefense(ThesisDefense thesisDefense);
	
	List<ThesisDefense> findThesisDefenseByEmail(String email);
	
	List<ThesisDefense> findAllByStatus(ThesisDefenseStatus thesisDefenseStatus);
	
	List<ThesisDefense> findAll();
	
	Optional<ThesisDefense> findById(Long id);
	
	void markDone(Long thesisDefenseId, String userLoginEmail);
}
