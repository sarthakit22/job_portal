package com.project.jobportal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/")
public class HomePageController {
	
	@GetMapping("/")
	public String homeScreen() {
		return "Welcome To Job Portal"+ "\n" +
				"GET-/sign-in"+"\n"+"POST-/sign-up";
	}
	
}
