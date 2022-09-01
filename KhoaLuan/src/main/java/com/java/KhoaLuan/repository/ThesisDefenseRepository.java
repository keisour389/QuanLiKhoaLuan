package com.java.KhoaLuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.KhoaLuan.domain.ThesisDefense;
import com.java.KhoaLuan.enums.ThesisDefenseStatus;

public interface ThesisDefenseRepository extends JpaRepository<ThesisDefense, Long> {
	
	@Query(value ="SELECT td.* FROM thesis_defense td "
			+ "LEFT JOIN thesis_defense_user tdu ON (td.id = tdu.thesis_defense_id) "
			+ "LEFT JOIN user u ON (tdu.user_id = u.id) "
			+ "LEFT JOIN study s ON (td.id = s.thesis_defense_id) "
			+ "WHERE u.email LIKE :email",
			nativeQuery = true)
	List<ThesisDefense> findThesisDefenseByEmail(@Param("email") String email);
	
	List<ThesisDefense> findAllByStatus(ThesisDefenseStatus thesisDefenseStatus);

}
