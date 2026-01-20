package com.example.springboot_crud.repository;

import com.example.springboot_crud.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <StudentModel,String> {

}
