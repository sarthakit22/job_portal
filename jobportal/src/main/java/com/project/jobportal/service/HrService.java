package com.project.jobportal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.jobportal.entity.HrHiring;
import com.project.jobportal.entity.UserEntity;
import com.project.jobportal.repository.HiringRepository;
import com.project.jobportal.repository.UserRepository;
import com.project.jobportal.request.HiringRequest;
import com.project.jobportal.response.ResponseBody;

@Service
public class HrService {

	@Autowired
	HiringRepository hireRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public ResponseEntity<ResponseBody> hiringInput(Long id,HiringRequest request) {
		if(request!=null) {
			HrHiring hiring=new HrHiring();
			hiring.setRole(request.getRole());
			hiring.setBranch(request.getBranch());
			hiring.setWorkingHours(request.getWorkingHours());
			hiring.setDateOfPosting(request.getDateOfPosting());//when post is added
			hiring.setNoOfApplicants(request.getNoOfApplicants());
			hiring.setCtc(request.getCtc());
			hiring.setLocation(request.getLocation());
			hiring.setExperience(request.getExperience());
			hiring.setId(id);
			hireRepo.save(hiring);
			return ResponseEntity.ok(new ResponseBody("welcome","thank you for hiring",hiring));
		}
			
		return ResponseEntity.ok(new ResponseBody("NO","Enter your correct details",null));
	}

	
	public ResponseEntity<ResponseBody> showHr(Long id) {
		Optional<UserEntity> hire=userRepo.findById(id);
		if(hire!=null) {
			return ResponseEntity.ok(new ResponseBody("welcome","Your post job details:",hire));
		}
		
		return ResponseEntity.ok(new ResponseBody("Sorry","please type correct hrId:",null));
	}

	
	public ResponseEntity<ResponseBody> deletePostJob(Long hrId) {
		return hireRepo.findById(hrId).map(data->{
			hireRepo.delete(data);
			return ResponseEntity.ok(new ResponseBody("Yes Available","deleted successfully",""));
			}).orElse(null);
	}	
}

