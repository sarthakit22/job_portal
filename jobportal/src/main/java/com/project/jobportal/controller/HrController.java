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
		return "1-> /sign-in"+ "\n" +
			   "2-> /sign-up"+"\n"
			   +"3-> /update-details"+"\n"
			   +"4-> /show-profile"+"\n"+
			   "5-> /delete-post-job"+"\n"+
			   "6-> /post-job"+"\n"+
			   "7-> /show-post-job"+"\n"+
			   "8-> check all apply details";
	}
	
	@PostMapping("/post-job")
	public ResponseEntity<?> postJob(@RequestParam Long id,@RequestBody HiringRequest request ){
		return hrService.hiringInput(id, request);		
	}
	
	@GetMapping("/show-postjob")
	public ResponseEntity<?> showHr(@RequestParam Long id){
		return hrService.showHr(id);		
	}

	@DeleteMapping("/delete-post-job")
	public ResponseEntity<?> deletePostJob(@RequestParam Long hrId){
		return hrService.deletePostJob(hrId);		
	}
}
