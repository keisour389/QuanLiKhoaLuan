package com.java.KhoaLuan.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.java.KhoaLuan.enums.CriteriaEnum;

/**
 * Criteria table
 * */
@Entity
@Table(name ="criteria")
public class Criteria extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name="name")
    @Enumerated(EnumType.STRING)
    private CriteriaEnum name;
    
    @OneToMany(mappedBy = "criteria")
    private Set<CriteriaStudyUser> criteriaStudyUser = new HashSet<CriteriaStudyUser>();
    
    public Criteria() {}
    
    public Criteria(CriteriaEnum name, User user) {
    	this.name = name;
    	this.setCreatedBy(user);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CriteriaEnum getName() {
		return name;
	}

	public void setName(CriteriaEnum name) {
		this.name = name;
	}

}
