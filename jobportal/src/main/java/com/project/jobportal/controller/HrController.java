package com.project.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.jobportal.request.HiringRequest;
import com.project.jobportal.service.HrService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class HrController {
	
	@Autowired
	HrService hrService;
	
	@GetMapping("/hr")
	public String hr() {
		return "1-> /post-job"+ "\n" +
			   "2-> /update-details"+"\n"
			   +"3-> /show-hr profile with post details"+"\n"
			   +"4-> /show-profile"+"\n"+
			   "5-> /delete-post-job";
	}
	
	@PostMapping("/post-job")
	public ResponseEntity<?> postJob(@RequestParam Long id,@RequestBody HiringRequest request ){
		return hrService.hiringInput(id, request);		
	}
	
	@GetMapping("/show-hr")
	public ResponseEntity<?> showHr(@RequestParam Long id){
		return hrService.showHr(id);		
	}

	@DeleteMapping("/delete-post-job")
	public ResponseEntity<?> deletePostJob(@RequestParam Long hrId){
		return hrService.deletePostJob(hrId);		
	}
}
