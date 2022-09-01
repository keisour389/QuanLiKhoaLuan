package com.java.KhoaLuan.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.java.KhoaLuan.enums.UserRole;

/**
 * User table
 * */
@Entity
@Table(name ="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name="first_name")
    private String firstName;
    
    @NotNull
    @Column(name="last_name")
    private String lastName;
	
    @NotNull
    @Column(name="email")
	private String email;
	
    @NotNull
    @Column(name="password_hash")
	private String password;
    
    @NotNull
    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    @Column(name="last_login_date")
    private Instant lastLoginDate;
    
	@NotNull
	@Column(name = "deleted")
	private boolean deleted = false;
	
	@Column(name = "created_by")
	private Long createdBy;
	
	@Column(name = "last_modified_by")
	private Long lastModifiedBy;
	
	@Column(name = "created_date")
	private Instant createdDate = Instant.now();
	
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate;
	
    @OneToMany(mappedBy = "user")
    private Set<ThesisDefenseUser> thesisDefenseUsers = new HashSet<ThesisDefenseUser>();
    
    @OneToMany(mappedBy = "user")
    private Set<CriteriaStudyUser> criteriaStudyUser = new HashSet<CriteriaStudyUser>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Instant getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Instant lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Set<ThesisDefenseUser> getThesisDefenseUsers() {
		return thesisDefenseUsers;
	}

	public void setThesisDefenseUsers(Set<ThesisDefenseUser> thesisDefenseUsers) {
		this.thesisDefenseUsers = thesisDefenseUsers;
	}
}
