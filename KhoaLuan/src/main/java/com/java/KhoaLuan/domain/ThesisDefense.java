package com.java.KhoaLuan.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import com.java.KhoaLuan.enums.ThesisDefenseStatus;

/**
 * ThesisDefense table
 * */
@Entity
@Table(name ="thesis_defense")
public class ThesisDefense extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ThesisDefenseStatus status;
    
    @OneToMany(mappedBy = "thesisDefense", fetch = FetchType.EAGER)
    @NotNull
    private Set<Study> study;
    
    @OneToMany(mappedBy = "thesisDefense", fetch = FetchType.EAGER)
    private Set<ThesisDefenseUser> thesisDefenseUsers = new HashSet<ThesisDefenseUser>();
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public ThesisDefenseStatus getStatus() {
		return status;
	}

	public void setStatus(ThesisDefenseStatus status) {
		this.status = status;
	}

	public Set<ThesisDefenseUser> getThesisDefenseUsers() {
		return thesisDefenseUsers;
	}

	public void setThesisDefenseUsers(Set<ThesisDefenseUser> thesisDefenseUsers) {
		this.thesisDefenseUsers = thesisDefenseUsers;
	}

	public Set<Study> getStudy() {
		return study;
	}

	public void setStudy(Set<Study> study) {
		this.study = study;
	}
}
