package com.example.springboot_crud.service;

import com.example.springboot_crud.exception.StudentNotFoundException;
import com.example.springboot_crud.model.StudentModel;
import com.example.springboot_crud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentModel addStudent(StudentModel student) {
        return repository.save(student);
    }

    public List<StudentModel> getStudents() {
        return repository.findAll();
    }

    public StudentModel updateStudent(String id, StudentModel student) {
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        existingStudent.setAge(student.getAge());
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        return repository.save(existingStudent);

    }

    public StudentModel deleteStudent(String id) {
        StudentModel st = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        repository.deleteById(id);
        return st;
    }
}
