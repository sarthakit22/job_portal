package com.project.jobportal.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String dob;
	private String age;
	
	@Column(name = "mobile_no", length = 10)
	private String mobileNo;
	
	private String email;
	private String city;
	private String state;
	
	@Column(name = "password", length = 8)
	private String password;
	private String role;
	private String approval;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<HrHiring> hiring;

	@OneToMany
	@JoinColumn(name="id")
	private List<ApplyEntity> applyDetails;

	
}