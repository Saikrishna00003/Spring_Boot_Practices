package com.sai.studentdetails.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sai.studentdetails.model.Person;

public interface PersonRepo extends MongoRepository<Person, Integer>{

}
