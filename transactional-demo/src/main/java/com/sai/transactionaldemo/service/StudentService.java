package com.sai.transactionaldemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import com.sai.transactionaldemo.entity.Student;
import com.sai.transactionaldemo.exception.ResourceNotFoundException;
import com.sai.transactionaldemo.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentrepo;

	@Transactional
	public Student saveStudent(Student student) {

		return studentrepo.save(student);

	}

	@Transactional(readOnly = true)
	public List<Student> getAllStudent() {
		return studentrepo.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Student> getStudentById(int id) {
		return studentrepo.findById(id);
	}

	@Transactional
	public void deleteStudentById(int id) {
		studentrepo.deleteById(id);
	}

	public Student updateStudent(int id, Student studentDetails) {
		Optional<Student> studentOptional = studentrepo.findById(id);
		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();
			student.setName(studentDetails.getName());
			student.setAddress(studentDetails.getAddress());
			student.setProjects(studentDetails.getProjects());
			return studentrepo.save(studentDetails);
		} else {
			
			//here i used my ResourceNotFoundException class object
			 throw new ResourceNotFoundException("student details not found with id: "+id);
		}

	}

}
