package com.example.demo.ControllerPractice;

import org.springframework.web.bind.annotation.*;

//@RestController
public class StudentController {

    @PostMapping("/students")
    public String create(@RequestBody Student student){
        return "Perform Create operation on the database.";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable("studentId") Integer studentId){
        return "Perform Reading operation on the database";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable("studentId") Integer studentId,
                         @RequestBody Student student){
        return "Perform Update operation on the database";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable("studentId") Integer studentId){
        return "Perform Delete operation on the database";
    }
}
