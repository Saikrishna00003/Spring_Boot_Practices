package com.sai.studentdetails.service;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sai.studentdetails.model.Person;
import com.sai.studentdetails.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;

	public Person addPerson(Person person) {
		return personRepo.save(person);
	}

	public Person updatePerson(int id,Person persondetails) {
		
		Optional<Person> optionalPerson=personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			Person existingPerson=optionalPerson.get();
			existingPerson.setName(persondetails.getName());
			existingPerson.setAge(persondetails.getAge());
			existingPerson.setAddress(persondetails.getAddress());
			
			return personRepo.save(existingPerson);
		}
		else {
			throw new RuntimeException("Person with ID " + id + " not found.");
			
		}
		
			}
	public Person deletePerson(int id) {
		Optional<Person> optionalPerson=personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			Person personToDelete=optionalPerson.get();
			personRepo.delete(personToDelete);
			return personToDelete;
		}
		else {
			throw new RuntimeException("Person with ID " + id + " not found.");
			
		}
		
	}
	public Person getPerson(int id) {
		return personRepo.findById(id).orElseThrow(()-> new RuntimeException("person with id:-"+id+"not found"));
	}
	
	public List<Person> getAllPersons(){
		return personRepo.findAll();
		}

}
