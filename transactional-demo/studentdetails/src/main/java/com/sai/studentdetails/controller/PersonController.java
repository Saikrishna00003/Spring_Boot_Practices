package com.sai.studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.studentdetails.model.Person;
import com.sai.studentdetails.service.PersonService;

@RestController
@RequestMapping("api/v1")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/person")
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}
	
	@PutMapping("/person/{id}")
	public Person updatePerson(@PathVariable int id,@RequestBody Person person) {
		return personService.updatePerson(id, person);
		
		
	}
	
	@DeleteMapping("/person/{id}")
	public Person deletePerson(@PathVariable int id) {
		return personService.deletePerson(id);
	}
	
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable int id) {
		return personService.getPerson(id);
		
	}
	
	@GetMapping("/persons")
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}
	

}
