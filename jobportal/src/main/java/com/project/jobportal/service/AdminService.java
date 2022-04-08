package com.project.jobportal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.jobportal.entity.HrHiring;
import com.project.jobportal.entity.UserEntity;
import com.project.jobportal.repository.ApplyRepository;
import com.project.jobportal.repository.HiringRepository;
import com.project.jobportal.repository.UserRepository;
import com.project.jobportal.response.ResponseBody;
import com.project.jobportal.response.UserResponse;

@Service
public class AdminService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	HiringRepository hireRepo;
	
	@Autowired
	ApplyRepository applyRepo;
	
	
	public ResponseEntity<ResponseBody> findAll(){
		List<UserEntity> user=userRepo.findAll();
		if(user.equals(null)) {
			return ResponseEntity.ok(new ResponseBody("USERS","NOT AVAILABLE",null));
		}
		return ResponseEntity.ok(new ResponseBody("YES","AVAILABLE",userRepo.findAll()));
    }
	
	
	public ResponseEntity<ResponseBody> findAllPost() {
		List<HrHiring> hire=hireRepo.findAll();
		if(hire.equals(null)) {
			return ResponseEntity.ok(new ResponseBody("POST JOBS","NOT AVAILABLE",null));
		}
		return ResponseEntity.ok(new ResponseBody("YES","POST JOBS AVAILABLE",hire));
	}
	
	
	public ResponseEntity<ResponseBody> findUserDetail(Long id) {
		UserEntity user=userRepo.findById(id).get();
		if(user.equals(null)) {
			return ResponseEntity.ok(new ResponseBody("NO","NOT AVAILABLE",null));
		}
		
		UserResponse user1=new UserResponse();
		user1.setId(user.getId());
		user1.setName(user.getName());
		user1.setDob(user.getDob());
		user1.setAge(user.getAge());
		user1.setMobileNo(user.getMobileNo());
		user1.setEmail(user.getEmail());
		user1.setCity(user.getCity());
		user1.setState(user.getState());
		user1.setRole(user.getRole());
		user1.setApproval(user.getApproval());
		return ResponseEntity.ok(new ResponseBody("YES","Details are:",user1));
	}
	
	
	public ResponseEntity<ResponseBody> adminApproval(Long id) {
		UserEntity user = userRepo.findById(id).get();
		if(user.equals(null)) {
			return ResponseEntity.ok(new ResponseBody("NO","NOT AVAILABLE",null));
		}
		user.setApproval("YES");
		userRepo.save(user);
		return ResponseEntity.ok(new ResponseBody("YES","APPROVED",user));
	}

	
	public ResponseEntity<ResponseBody> deleteDetail(Long id) {
		return userRepo.findById(id).map(data->{
			userRepo.delete(data);
			return ResponseEntity.ok(new ResponseBody("Yes Available","deleted successfully",""));
			}).orElse(null);
	}

	
	public ResponseEntity<?> applyDetails() {
		return ResponseEntity.ok(new ResponseBody("All Aplly Details","Hello Boss",applyRepo.findAll()));
	}
	
}
