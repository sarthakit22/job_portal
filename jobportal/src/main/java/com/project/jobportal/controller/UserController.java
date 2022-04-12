package com.project.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.jobportal.request.ApplyRequest;
import com.project.jobportal.request.PasswordRequest;
import com.project.jobportal.request.UpdateRequest;
import com.project.jobportal.service.HrService;
import com.project.jobportal.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	HrService hrService;
	
	@GetMapping("/user")
	public String user() {
		return "1-> /filter-job" + "\n"+ 
			   "2-> /apply-job" + "\n" +
			   "3-> /update-details"  + "\n" +
			   "4-> /update-password" +"\n" +
			   "5-> /show-profile";
	}
	
	@PostMapping("/apply-job")
	public ResponseEntity<?> applyJob(@RequestParam Long id,@RequestParam Long hrId
			,@RequestBody ApplyRequest request){
		return userService.applyJob(id, hrId,request);
		
	}
	
	@GetMapping("/filter-job")
	public ResponseEntity<?> showJob(@RequestParam String branch,@RequestParam String experience){
		return userService.showJob(branch,experience);			
    }
	
	@PutMapping("/update-details")
	public ResponseEntity<?> update(@RequestParam Long id,@RequestBody UpdateRequest request){
		return userService.update(id, request);
	}
	
	@PutMapping("/update-password")
	public ResponseEntity<?> updatePassword(@RequestParam Long id,@RequestBody PasswordRequest request){
		return userService.updatePassword(id, request);
	
	}
}
