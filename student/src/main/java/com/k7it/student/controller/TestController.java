package com.k7it.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.k7it.student.model.StudentDetails;


@RestController
@RequestMapping("api/v1")
public class TestController {
	
	@GetMapping("/sayHello")
	public String sayHelloWorld() {
		return "hey sai";
	}
	
	@PostMapping("/createStudent")
	public String createStudent(@RequestBody StudentDetails student) {
		
		
		return student.toString();
	}

}
