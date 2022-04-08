package com.project.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.jobportal.request.SignIn;
import com.project.jobportal.request.UserRequest;
import com.project.jobportal.response.ResponseBody;
import com.project.jobportal.service.HrService;
import com.project.jobportal.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	HrService hrService;
	
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody UserRequest request){
		return userService.signUp(request);
	}
	
	
	@GetMapping("/sign-in")
	public ResponseEntity<ResponseBody> signIn(@RequestBody SignIn request){
		return userService.signIn(request);
	}

}
