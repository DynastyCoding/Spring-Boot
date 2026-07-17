package com.example.demo.JDBC;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/students/table")
    public String createTable(){
        studentService.createTable();
        return "Data table create successfully.";
    }
}
