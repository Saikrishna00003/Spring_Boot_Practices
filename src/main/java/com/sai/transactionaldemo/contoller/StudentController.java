package com.sai.transactionaldemo.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.transactionaldemo.entity.Student;
import com.sai.transactionaldemo.exception.ResourceNotFoundException;
import com.sai.transactionaldemo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	StudentService studentservice;

	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		return studentservice.saveStudent(student);
	}

	@GetMapping("/liststudents")
	public List<Student> getAllStudents() {
		return studentservice.getAllStudent();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		Optional<Student> studentOptional=studentservice.getStudentById(id);
		if(studentOptional.isPresent()) {
			return studentOptional.get();
		}
		else {
			throw new ResourceNotFoundException("student with"+id+"not found");
		}
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteById(@PathVariable int id) {
		studentservice.deleteStudentById(id);
	}
	
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable int id,@RequestBody Student studentdetails) {
		try {
		return studentservice.updateStudent(id, studentdetails);
		}
		catch(ResourceNotFoundException e){
			throw new ResourceNotFoundException("student not found with id: "+id);			
		}
	}

}
