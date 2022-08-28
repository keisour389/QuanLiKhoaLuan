package com.java.KhoaLuan.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.java.KhoaLuan.enums.UserRole;

/**
 * User table
 * */
@Entity
@Table(name ="user")
public class User extends AbstractEntity implements Serializable {

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
    
    @NotNull
    @Column(name="last_login_date")
    private Instant lastLoginDate;

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
		
}
