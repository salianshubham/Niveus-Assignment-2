package com.example.Assignment2.controller;

import com.example.Assignment2.model.StudentModel;
import com.example.Assignment2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping()
    public StudentModel insertStudent(@RequestBody StudentModel studentModel){
        System.out.println("Data From front end "+ studentModel);
        return studentService.saveStudent(studentModel);
    }

    @GetMapping("/{id}")
    public Optional<StudentModel> getStudent(@PathVariable int id){
        return studentService.getStudentById(id);
    }


    @PutMapping("/{id}")
    public StudentModel updateStudent(@PathVariable int id, @RequestBody StudentModel studentModel){
        studentModel.setId(id);
        return studentService.updateStudent(studentModel);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student with ID " + id + " deleted successfully.";
    }
}
