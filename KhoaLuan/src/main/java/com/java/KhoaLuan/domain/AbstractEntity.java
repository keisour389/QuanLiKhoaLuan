package com.java.KhoaLuan.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class AbstractEntity {
	
	@NotNull
	@Column(name = "deleted")
	private boolean deleted = false;
	
    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name="created_by", nullable = false)
	private User createdBy;
	
    @ManyToOne(optional = true)
    @JoinColumn(name="last_modified_by", nullable = true)
	private User lastModifiedBy;
	
	@Column(name = "created_date")
	private Instant createdDate = Instant.now();
	
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate;

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
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
}
