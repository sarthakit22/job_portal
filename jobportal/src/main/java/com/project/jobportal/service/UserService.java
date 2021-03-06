package com.project.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.jobportal.entity.ApplyEntity;
import com.project.jobportal.entity.HrHiring;
import com.project.jobportal.entity.UserEntity;
import com.project.jobportal.repository.ApplyRepository;
import com.project.jobportal.repository.HiringRepository;
import com.project.jobportal.repository.UserRepository;
import com.project.jobportal.request.ApplyRequest;
import com.project.jobportal.request.PasswordRequest;
import com.project.jobportal.request.SignIn;
import com.project.jobportal.request.UpdateRequest;
import com.project.jobportal.request.UserRequest;
import com.project.jobportal.response.ResponseBody;
import com.project.jobportal.response.ShowJobResponse;
import com.project.jobportal.response.UserResponse;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	HiringRepository hiringrepo;
	
	@Autowired
	ApplyRepository applyRepo;
	
	
    /*----------------------------------------------------------------------------------------------*/
	public ResponseEntity<ResponseBody> signUp(UserRequest request) {
		String email1="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern=Pattern.compile(email1);
		
		String mobile="(0/91)?[7-9][0-9]{9}";
		Pattern pattern1=Pattern.compile(mobile);
		
		if(!pattern.matcher(request.getEmail()).matches()){
			return ResponseEntity.ok(new ResponseBody("NO","Enter valid Email ID:" ,null));
		}
		
		if(!pattern1.matcher(request.getMobileNo()).matches()){
			return ResponseEntity.ok(new ResponseBody("NO","Enter valid Mobile No.:" ,null));
		}
		
			UserEntity user = new UserEntity();
			user.setName(request.getName());
			user.setDob(request.getDob());
			user.setAge(request.getAge());
			user.setMobileNo(request.getMobileNo());
			user.setEmail(request.getEmail());
			user.setCity(request.getCity());
			user.setState(request.getState());
			user.setPassword(request.getPassword());
			user.setRole(request.getRole());
			user.setApproval("NO");
			userRepo.save(user);
			return ResponseEntity.ok(new ResponseBody("YES","Your Id is:" , user.getId()));
	}
	
	
	/*----------------------------------------------------------------------------------------------*/
	public ResponseEntity<ResponseBody> signIn(SignIn request) {
		if(request.getEmail()==null) {
			return ResponseEntity.ok(new ResponseBody("NO","Enter Email",null));
		}
		if(request.getPassword()==null) {
			return ResponseEntity.ok(new ResponseBody("NO","Enter Password",null));
		}
		
			UserEntity login=userRepo.findByEmailAndPassword(request.getEmail(), request.getPassword());
			if(login!=null) {
				UserResponse user=new UserResponse();
				user.setId(login.getId());			
				user.setName(login.getName());
				user.setDob(login.getDob());
				user.setAge(login.getAge());
				user.setMobileNo(login.getMobileNo());
				user.setEmail(login.getEmail());
				user.setCity(login.getCity());
				user.setState(login.getState());
				user.setRole(login.getRole());
				user.setApproval(login.getApproval());
				return ResponseEntity.ok(new ResponseBody("Success","Login Successfully",user));
			}
			return ResponseEntity.ok(new ResponseBody("Oops","You have not registered:",""));
	}

	
	/*----------------------------------------------------------------------------------------------*/
	//error
	public ResponseEntity<ResponseBody> showJob(String branch,String experience) {
		
		List<HrHiring> jobList=hiringrepo.branchEx(branch,experience);
		if(jobList!=null) {
			
			ShowJobResponse job;
			List<ShowJobResponse> list=new ArrayList();
			for (HrHiring job1 : jobList) {
				job=new ShowJobResponse();
				job.setHrId(job1.getHrId());
				job.setBranch(job1.getBranch());
				job.setRole(job1.getRole());
				job.setWorkingHours(job1.getWorkingHours());
				job.setDateOfPosting(job1.getDateOfPosting());
				job.setNoOfApplicants(job1.getNoOfApplicants());
				job.setCtc(job1.getCtc());
				job.setLocation(job1.getLocation());
				job.setExperience(job1.getExperience());
				list.add(job);
			}
			return ResponseEntity.ok(new ResponseBody("YES AVAILABLE","Listed",list));
		}
		return ResponseEntity.ok(new ResponseBody("NOT AVAILABLE","Try with Different branch and experience",null));

//		if(branch==null || branch=="") {
//			ResponseEntity.ok(new ResponseBody("Sorry","Enter correct branch",""));
//		}
//		if(experience==null || experience=="") {
//			ResponseEntity.ok(new ResponseBody("Sorry","Enter correct experience",""));
//		}
		
	}

	
	/*----------------------------------------------------------------------------------------------*/
	public ResponseEntity<ResponseBody> applyJob(Long id, Long hr_id, ApplyRequest request) {
		
		try {
		if(request.getCurrentYear().equals(null) && request.getField().equals(null)) {
			//return ResponseEntity.ok(new ResponseBody("","Enter valid year or field",null));
		}
		ApplyEntity apply = new ApplyEntity();
		apply.setId(id);
		apply.setHrId(hr_id);
		apply.setCurrentYear(request.getCurrentYear());
		apply.setField(request.getField());
		applyRepo.save(apply);
		return ResponseEntity.ok(new ResponseBody("Applied Your id is:","Send your Resume to hr@gmail.com",apply.getApplyId()));
		}
		
		catch(Exception e) {
			return ResponseEntity.ok(new ResponseBody("","Enter valid year or field",null));
		}
	}


	/*----------------------------------------------------------------------------------------------*/
	public ResponseEntity<ResponseBody> update(Long id, UpdateRequest request) {
		
		UserEntity user = userRepo.findById(id).get(); 
		user.setName(request.getName());
		user.setDob(request.getDob());
		user.setAge(request.getAge());
		user.setMobileNo(request.getMobileNo());
		user.setEmail(request.getEmail());
		user.setCity(request.getCity());
		user.setState(request.getState());
		userRepo.save(user);
		return ResponseEntity.ok(new ResponseBody("Updated","Successfully",""));
	}

	
	/*----------------------------------------------------------------------------------------------*/
	public ResponseEntity<?> updatePassword(Long id, PasswordRequest request) {
//		if(request.getPassword().equals(null)) {
//			return ResponseEntity.ok(new ResponseBody("No","Enter Paswword properly",""));
//		}
		
		UserEntity user = userRepo.findById(id).get();
		if(user.equals(null)) {
			return ResponseEntity.ok(new ResponseBody("No","Enter Correct Id:",""));
		}
		user.setPassword(request.getPassword());
		user.setId(id);
		userRepo.save(user);
		return ResponseEntity.ok(new ResponseBody("Password Updated","Successfully",""));
	}


	public ResponseEntity<ResponseBody> showProfile(Long id) {
		UserEntity user=userRepo.findById(id).get();
		if(user==null) {
			return ResponseEntity.ok(new ResponseBody("No","Not Available",null));
		}
		return ResponseEntity.ok(new ResponseBody("Yes","Available",user));		
	}
	
}
