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

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
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

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(long id, String name, String dob, String age, String mobileNo, String email, String city,
			String state, String password, String role, String approval, List<HrHiring> hiring) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.mobileNo = mobileNo;
		this.email = email;
		this.city = city;
		this.state = state;
		this.password = password;
		this.role = role;
		this.approval = approval;
		this.hiring = hiring;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public List<HrHiring> getHiring() {
		return hiring;
	}

	public void setHiring(List<HrHiring> hiring) {
		this.hiring = hiring;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", dob=" + dob + ", age=" + age + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", city=" + city + ", state=" + state + ", password=" + password + ", role="
				+ role + ", approval=" + approval + ", hiring=" + hiring + "]";
	}	
	
		}