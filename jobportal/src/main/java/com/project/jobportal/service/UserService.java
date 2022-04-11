package com.project.jobportal.service;

import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.jobportal.entity.ApplyEntity;
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
		
		if(request.getEmail().equals(null) || request.getEmail().isEmpty()) {
			return ResponseEntity.ok(new ResponseBody("NO","Enter Your Email" ,null));
		}
	    
		if(!( (pattern.matcher(request.getEmail()).matches()) && (pattern1.matcher(request.getMobileNo()).matches()) )){
			return ResponseEntity.ok(new ResponseBody("NO","Enter valid Email ID or Mobile No.:" ,null));
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
		if(request.getEmail()!=null) {
			if(request.getPassword()!=null) {
				UserEntity login=userRepo.findByEmailAndPassword(request.getEmail(), request.getPassword());
				if(login!=null) {
					return ResponseEntity.ok(new ResponseBody("Success","Login Successfully",login));
				}
				return ResponseEntity.ok(new ResponseBody("Oops","You have not registered:",""));
			}
			return ResponseEntity.ok(new ResponseBody("Oops","Enter Password",""));
		}
		return ResponseEntity.ok(new ResponseBody("Oops","Enter Email",""));
	}

	
	/*----------------------------------------------------------------------------------------------*/
	public ResponseEntity<ResponseBody> showJob(String branch,String experience) {
		if(branch==null && experience==null) {
			ResponseEntity.ok(new ResponseBody("Sorry","Enter correct branch or experience",""));
		}
		return ResponseEntity.ok(new ResponseBody("YES AVAILABLE","Listed",hiringrepo.branchEx(branch,experience)));
	}

	
	/*----------------------------------------------------------------------------------------------*/
	public ResponseEntity<ResponseBody> applyJob(Long id, Long hr_id, ApplyRequest request) {
		if(request.getCurrentYear().equals(null) && request.getField().equals(null)) {
			return ResponseEntity.ok(new ResponseBody("","Enter valid year or field",null));
		}
		ApplyEntity apply = new ApplyEntity();
		apply.setId(id);
		apply.setHrId(hr_id);
		apply.setCurrentYear(request.getCurrentYear());
		apply.setField(request.getField());
		applyRepo.save(apply);
		return ResponseEntity.ok(new ResponseBody("Applied Your id is:","Send your Resume to hr@gmail.com",apply.getApplyId()));
	}


	/*----------------------------------------------------------------------------------------------*/
	public ResponseEntity<ResponseBody> update(Long id, UpdateRequest request) {
		if(request!=null) {
		UserEntity user = userRepo.findById(id).get(); 
		user.setName(request.getName());
		user.setDob(request.getDob());
		user.setAge(request.getAge());
		user.setMobileNo(request.getMobileNo());
		user.setEmail(request.getEmail());
		user.setCity(request.getCity());
		user.setState(request.getState());
		user.setRole(request.getRole());
		userRepo.save(user);
		return ResponseEntity.ok(new ResponseBody("Updated","Successfully",""));
		}
		else {
			return ResponseEntity.ok(new ResponseBody("Sorry","Enter Correct Details",""));
		}
	}

	
	/*----------------------------------------------------------------------------------------------*/
	public ResponseEntity<?> updatePassword(Long id, PasswordRequest request) {
		if(request.getPassword().equals(null)) {
			return ResponseEntity.ok(new ResponseBody("No","Enter Paswword properly",""));
		}
		UserEntity user = userRepo.findById(id).get();
		if(user.equals(null)) {
			return ResponseEntity.ok(new ResponseBody("No","Enter Correct Id:",""));
		}
		user.setPassword(request.getPassword());
		user.setId(id);
		userRepo.save(user);
		return ResponseEntity.ok(new ResponseBody("Password Updated","Successfully",""));
	}
}
