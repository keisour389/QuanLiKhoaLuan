package com.java.KhoaLuan.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * ThesisDefenseUser table
 * */
@Entity
@Table(name ="criteria_study_user")
@IdClass(CriteriaStudyUserId.class)
public class CriteriaStudyUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @NotNull
    @Column(name = "criteria_id")
    protected Long criteriaId;
    
    @ManyToOne
    @JoinColumn(name = "criteria_id", insertable = false, updatable = false)
    private Study criteria;
	
	@Id
    @NotNull
    @Column(name = "study_id")
    protected Long studyId;
    
    @ManyToOne
    @JoinColumn(name = "study_id", insertable = false, updatable = false)
    private Study study;

	@Id
    @NotNull
    @Column(name = "user_id")
    protected Long userId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    
    @NotNull
    @Column(name = "score")
    private Double score;

	public Long getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(Long criteriaId) {
		this.criteriaId = criteriaId;
	}

	public Study getCriteria() {
		return criteria;
	}

	public void setCriteria(Study criteria) {
		this.criteria = criteria;
	}

	public Long getStudyId() {
		return studyId;
	}

	public void setStudyId(Long studyId) {
		this.studyId = studyId;
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}
