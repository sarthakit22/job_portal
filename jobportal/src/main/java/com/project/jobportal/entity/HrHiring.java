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
@Table(name="hiring")
public class HrHiring {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hrId;
	private String branch;
	private String role;
	private String workingHours;
	private String dateOfPosting;
	private String noOfApplicants;
	private String ctc;
	private String location;
	private String experience;
	
	@Column(name="id")
	private long id;   //hr-userId
	
	@OneToMany
	@JoinColumn(name="hr_id")
	List<ApplyEntity> applyDetails;

	public HrHiring() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrHiring(long hrId, String branch, String role, String workingHours, String dateOfPosting,
			String noOfApplicants, String ctc, String location, String experience, long id,
			List<ApplyEntity> applyDetails) {
		super();
		this.hrId = hrId;
		this.branch = branch;
		this.role = role;
		this.workingHours = workingHours;
		this.dateOfPosting = dateOfPosting;
		this.noOfApplicants = noOfApplicants;
		this.ctc = ctc;
		this.location = location;
		this.experience = experience;
		this.id = id;
		this.applyDetails = applyDetails;
	}

	public long getHrId() {
		return hrId;
	}

	public void setHrId(long hrId) {
		this.hrId = hrId;
	}

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ApplyEntity> getApplyDetails() {
		return applyDetails;
	}

	public void setApplyDetails(List<ApplyEntity> applyDetails) {
		this.applyDetails = applyDetails;
	}

	@Override
	public String toString() {
		return "HrHiring [hrId=" + hrId + ", branch=" + branch + ", role=" + role + ", workingHours=" + workingHours
				+ ", dateOfPosting=" + dateOfPosting + ", noOfApplicants=" + noOfApplicants + ", ctc=" + ctc
				+ ", location=" + location + ", experience=" + experience + ", id=" + id + ", applyDetails="
				+ applyDetails + "]";
	}
	
}