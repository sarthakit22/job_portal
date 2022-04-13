package com.project.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.jobportal.response.ResponseBody;
import com.project.jobportal.service.AdminService;

@RestController
@CrossOrigin
@RequestMapping("/")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	//trial
	@GetMapping("/admin")
	public String admin() {
		return "1-> /sign-in"+ "\n"+ 
				"2-> /all-users"+"\n"+
			    "3-> /only-post-jobs"+ "\n"+
			   "4-> /unique-user-detail"+ "\n"+
			   "5-> /admin-approval"+ "\n"+
			   "6-> /delete-details"+"\n"+         //before approval
			   "7-> /only-apply-details"+"\n"+
			   "8-> /update-details"+"\n"+
			   "9-> /update-password";
	}
	
	@GetMapping("/all-users")
	public ResponseEntity<?> findAlll(){
		return adminService.findAll();	
	}
	
	@GetMapping("/only-post-jobs")
	public ResponseEntity<?> findAll(){
		return adminService.findAllPost();		
	}
	
	@GetMapping("/unique-user-detail")
	public ResponseEntity<?> findUserDetail(@RequestParam Long id) {
		return adminService.findUserDetail(id);
	}
	
	@PutMapping("/admin-approval")
	public ResponseEntity<?> adminApproval(@RequestParam Long id){
		return adminService.adminApproval(id);
	}
	
	@DeleteMapping("/delete-details")
	public ResponseEntity<?> deleteDetail(@RequestParam Long id){
		return adminService.deleteDetail(id);
	}
	
	@GetMapping("/only-apply-details")
	public ResponseEntity<?> applyDetails(){
		return adminService.applyDetails();
	}
}
