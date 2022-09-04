package com.java.KhoaLuan.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

/**
 * Study table
 * */
@Entity
@Table(name ="study")
public class Study extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="school_year")
    private String schoolYear;
    
    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name="thesis_defense_id", nullable = false)
    private ThesisDefense thesisDefense;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_study",
        joinColumns = {@JoinColumn(name = "study_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> users = new HashSet<>();
    
    @OneToMany(mappedBy = "study")
    private Set<CriteriaStudyUser> criteriaStudyUser = new HashSet<CriteriaStudyUser>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	
	public ThesisDefense getThesisDefense() {
		return thesisDefense;
	}

	public void setThesisDefense(ThesisDefense thesisDefense) {
		this.thesisDefense = thesisDefense;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<CriteriaStudyUser> getCriteriaStudyUser() {
		return criteriaStudyUser;
	}

	public void setCriteriaStudyUser(Set<CriteriaStudyUser> criteriaStudyUser) {
		this.criteriaStudyUser = criteriaStudyUser;
	}
}
