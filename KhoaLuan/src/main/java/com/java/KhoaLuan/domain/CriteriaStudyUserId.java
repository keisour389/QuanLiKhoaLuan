package com.java.KhoaLuan.domain;

import java.io.Serializable;

public class CriteriaStudyUserId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long criteriaId;
	
	private Long studyId;
	
	private Long userId;

	public Long getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(Long criteriaId) {
		this.criteriaId = criteriaId;
	}

	public Long getStudyId() {
		return studyId;
	}

	public void setStudyId(Long studyId) {
		this.studyId = studyId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
