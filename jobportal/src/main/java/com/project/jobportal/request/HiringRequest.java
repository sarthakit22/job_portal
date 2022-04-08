package com.project.jobportal.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HiringRequest {
	private String branch;
	private String role;
	private String workingHours;
	private String dateOfPosting;
	private String noOfApplicants;
	private String ctc;
	private String location;
	private String experience;
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	public String getDateOfPosting() {
		return dateOfPosting;
	}
	public void setDateOfPosting(String dateOfPosting) {
		this.dateOfPosting = dateOfPosting;
	}
	public String getNoOfApplicants() {
		return noOfApplicants;
	}
	public void setNoOfApplicants(String noOfApplicants) {
		this.noOfApplicants = noOfApplicants;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	
}

