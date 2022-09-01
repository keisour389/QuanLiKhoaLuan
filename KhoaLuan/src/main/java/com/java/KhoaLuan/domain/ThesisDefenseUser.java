package com.java.KhoaLuan.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.java.KhoaLuan.enums.ThesisDefenseRole;


/**
 * ThesisDefenseUser table
 * */
@Entity
@Table(name ="thesis_defense_user")
@IdClass(ThesisDefenseUserId.class)
public class ThesisDefenseUser implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "user_id")
    protected Long userId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    
    @Id
    @NotNull
    @Column(name = "thesis_defense_id")
    protected Long thesisDefenseId;
    
    @ManyToOne
    @JoinColumn(name = "thesis_defense_id", insertable = false, updatable = false)
    private ThesisDefense thesisDefense;

    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private ThesisDefenseRole role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ThesisDefense getThesisDefense() {
		return thesisDefense;
	}

	public void setThesisDefense(ThesisDefense thesisDefense) {
		this.thesisDefense = thesisDefense;
	}

	public ThesisDefenseRole getRole() {
		return role;
	}

	public void setRole(ThesisDefenseRole role) {
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getThesisDefenseId() {
		return thesisDefenseId;
	}

	public void setThesisDefenseId(Long thesisDefenseId) {
		this.thesisDefenseId = thesisDefenseId;
	}
}
