package com.abc.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public abstract class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@CreatedDate
	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdAt;

	@LastModifiedDate
	@Column(name = "updated")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date updatedAt;
	
	@CreatedBy
	@Column(name = "created_by", nullable = true)
	protected String createdBy;

	@LastModifiedBy
	@Column(name = "updated_by", nullable = true)
	protected String updatedBy;

}