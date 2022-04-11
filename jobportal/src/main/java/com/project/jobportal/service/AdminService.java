package com.project.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.jobportal.entity.HrHiring;
import com.project.jobportal.entity.UserEntity;
import com.project.jobportal.repository.ApplyRepository;
import com.project.jobportal.repository.HiringRepository;
import com.project.jobportal.repository.UserRepository;
import com.project.jobportal.response.PostResponse;
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
		List<UserEntity> userList=userRepo.findAll();
		if(userList.isEmpty()) {
			return ResponseEntity.ok(new ResponseBody("USERS","NOT AVAILABLE",null));
		}
		List<UserResponse> list=new ArrayList();
		UserResponse user;
		for (UserEntity userEntity : userList) {
			user=new UserResponse();
			user.setId(userEntity.getId());
			user.setName(userEntity.getName());
			user.setDob(userEntity.getDob());
			user.setAge(userEntity.getAge());
			user.setMobileNo(userEntity.getMobileNo());
			user.setEmail(userEntity.getEmail());
			user.setCity(userEntity.getCity());
			user.setState(userEntity.getState());
			user.setRole(userEntity.getRole());
			user.setApproval(userEntity.getApproval());
			list.add(user);
		}
		return ResponseEntity.ok(new ResponseBody("YES","AVAILABLE",list));
    }
	
	
	public ResponseEntity<ResponseBody> findAllPost() {
		List<HrHiring> hireList=hireRepo.findAll();
		if(hireList.isEmpty()) {
			return ResponseEntity.ok(new ResponseBody("POST JOBS","NOT AVAILABLE",null));
		}
		List<PostResponse> list=new ArrayList();
		PostResponse post;
		for (HrHiring hiring : hireList) {
			post=new PostResponse();
			post.setHrId(hiring.getHrId());
			post.setBranch(hiring.getBranch());
			post.setRole(hiring.getRole());
			post.setWorkingHours(hiring.getWorkingHours());
			post.setDateOfPosting(hiring.getDateOfPosting());
			post.setNoOfApplicants(hiring.getNoOfApplicants());
			post.setCtc(hiring.getCtc());
			post.setLocation(hiring.getLocation());
			post.setExperience(hiring.getExperience());
			list.add(post);
		}
		return ResponseEntity.ok(new ResponseBody("YES","POST JOBS AVAILABLE",list));
	}
	
	
	public ResponseEntity<ResponseBody> findUserDetail(Long id) {
		try{
			UserEntity user=userRepo.findById(id).get();
		if(user.equals(null)) {
		//	return ResponseEntity.ok(new ResponseBody("NO","NOT AVAILABLE",null));
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
		
		catch(Exception e) {
			return ResponseEntity.ok(new ResponseBody("NO","NOT AVAILABLE",null));
		}
	}
	
	
	public ResponseEntity<ResponseBody> adminApproval(Long id){
		try {
		UserEntity user = userRepo.findById(id).get();
		if(user.equals(null)) {
			//return ResponseEntity.ok(new ResponseBody("NO","NOT AVAILABLE",null));
		}
		user.setApproval("YES");
		userRepo.save(user);
		return ResponseEntity.ok(new ResponseBody("YES","APPROVED",user));
		}
		
		catch(Exception e) {
			return ResponseEntity.ok(new ResponseBody("NO","NOT AVAILABLE",null));
		}
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
