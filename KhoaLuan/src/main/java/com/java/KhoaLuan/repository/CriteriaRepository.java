package com.java.KhoaLuan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.KhoaLuan.domain.Criteria;

public interface CriteriaRepository extends JpaRepository<Criteria, Long> {


}
