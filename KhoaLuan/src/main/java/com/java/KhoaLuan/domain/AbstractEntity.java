package com.java.KhoaLuan.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public abstract class AbstractEntity {
	
	@NotNull
	@Column(name = "deleted")
	private boolean deleted;
	
	@Column(name = "created_by")
	private Long createdBy;
	
	@Column(name = "last_modified_by")
	private Long lastModifiedBy;
	
	@Column(name = "created_date")
	private Instant createDate;
	
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate;

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

	public Instant getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Instant createDate) {
		this.createDate = createDate;
	}

	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
