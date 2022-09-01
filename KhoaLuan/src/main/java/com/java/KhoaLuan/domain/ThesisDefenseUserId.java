package com.java.KhoaLuan.domain;

import java.io.Serializable;

public class ThesisDefenseUserId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	
	private Long thesisDefenseId;
	
	public ThesisDefenseUserId() {}

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
