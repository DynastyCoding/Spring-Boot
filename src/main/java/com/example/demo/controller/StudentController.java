package com.example.demo.controller;

import com.example.demo.dto.request.CreateStudentRequest;
import com.example.demo.dto.response.StudentResponse;
import com.example.demo.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Student", description = "Student management API")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentResponse> getAll(){
        return studentService.getAllStudents();
    }

    @Operation(summary = "New students")
    @PostMapping("/students")
    public StudentResponse create(
            @RequestBody CreateStudentRequest req){
        return studentService.createStudent(req);
    }

    @ApiResponse(responseCode = "200", description = "Query successful")
    @GetMapping("/students/{id}")
    public StudentResponse getById(@PathVariable("id") Integer id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/students/{id}")
    public StudentResponse update(
            @PathVariable("id") Integer id,
            @RequestBody CreateStudentRequest req){
        return studentService.updateStudent(id, req);
    }

    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable("id") Integer id){
        studentService.deleteStudent(id);
    }
}
