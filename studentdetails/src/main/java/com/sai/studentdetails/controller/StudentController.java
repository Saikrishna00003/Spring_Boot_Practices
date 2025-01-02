package com.sai.studentdetails.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sai.studentdetails.model.Address;
import com.sai.studentdetails.model.Student;
import com.sai.studentdetails.model.StudentAddress;

@RestController
@RequestMapping("api/v1")
public class StudentController {

	@GetMapping("/hisai")
	public String SayHi() {
		return "Hi sai";
	}

	@PostMapping("/createStudent")
	public String createStudent(@RequestBody Student student) {

		// return "id"+student.getId()+student.getName();
		// OR
		return student.toString();
	}

	@PostMapping("/addStudent")
	public String AddStudent(@RequestParam int id, @RequestParam String name, @RequestParam String branch,
			@RequestParam int marks, @RequestParam String address) {

		return new Student(id, name, branch, marks, address).toString();
	}

	@GetMapping("/getStudent")
	public String GetStudent(@RequestParam int id, @RequestParam String name, @RequestParam String branch,
			@RequestParam int marks, @RequestParam String address) {

		// return "Student{id=" + id + ", name='" + name + "', branch='" + branch + "',
		// marks=" + marks + ", address='" + address + "'}";
		// OR
		return new Student(id, name, branch, marks, address).toString();
	}

	@GetMapping("/add")
	public int add(@RequestParam int n1, @RequestParam int n2) {

		return n1 + n2;
	}

	@GetMapping("/getStudent/{id}")
	public String getStudent(@PathVariable int id) {

		return "Student details for id:" + id + " is:" + new Student(102, "k7it", "cse", 99, "Bangalore").toString();
	}

	@GetMapping("/studentAddress")
	public StudentAddress insertStudentwithAddress(@RequestBody StudentAddress studentAddress) {

		Student student = studentAddress.getStudent();
		Address address = studentAddress.getAddress();

		return studentAddress;
	}

}