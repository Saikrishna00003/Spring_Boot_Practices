package com.sai.transactionaldemo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sai.transactionaldemo.entity.Student;

public interface StudentRepo extends MongoRepository<Student, Integer>{

}
