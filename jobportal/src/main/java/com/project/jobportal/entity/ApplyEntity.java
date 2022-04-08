package com.project.jobportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="apply")
public class ApplyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long applyId;
	
	private String currentYear;
	private String field;
	
	@Column(name="hr_id")  //hiring-id
	private long hrId;
	
	@Column(name="id")
	private long id;    //user-id--for ADMIN,HR,USER

	public ApplyEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplyEntity(long applyId, String currentYear, String field, long hrId, long id) {
		super();
		this.applyId = applyId;
		this.currentYear = currentYear;
		this.field = field;
		this.hrId = hrId;
		this.id = id;
	}

	public long getApplyId() {
		return applyId;
	}

	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}

	public String getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public long getHrId() {
		return hrId;
	}

	public void setHrId(long hrId) {
		this.hrId = hrId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ApplyEntity [applyId=" + applyId + ", currentYear=" + currentYear + ", field=" + field + ", hrId="
				+ hrId + ", id=" + id + "]";
	}
}	