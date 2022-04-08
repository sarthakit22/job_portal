package com.project.jobportal.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
	
	private String name;
	private String dob;
	private String age;
	private String mobileNo;
	private String email;
	private String city;
	private String state;
	private String password;
	private String role;
	 
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub	
	}
	
	public UserRequest(String name, String dob, String age, String mobileNo, String email, String city, String state,
			String password,String role) {
		super();
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.mobileNo = mobileNo;
		this.email = email;
		this.city = city;
		this.state = state;
		this.password = password;
		this.role=role;
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
	
	
	

}
