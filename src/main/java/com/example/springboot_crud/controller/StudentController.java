package com.example.springboot_crud.controller;


import com.example.springboot_crud.model.StudentModel;
import com.example.springboot_crud.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    @PostMapping("/add-student")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return service.addStudent(student);
    }

    @GetMapping("/students")
    public List<StudentModel> getStudents(){
        return service.getStudents();
    }

    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id,@RequestBody StudentModel student){
        return service.updateStudent(id,student);
    }

    @DeleteMapping("/delete/{id}")
    public StudentModel deleteStudent(@PathVariable String id){
        return service.deleteStudent(id);
    }
}
