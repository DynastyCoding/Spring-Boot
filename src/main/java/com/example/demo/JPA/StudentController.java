package com.example.demo.JPA;

import org.springframework.web.bind.annotation.*;

//@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public String create(@RequestBody Student student) {
        studentService.createStudent(student);
        return "新增成功";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable(name = "studentId") Integer studentId,
                         @RequestBody Student student) {
        studentService.updateStudent(studentId, student);
        return "修改成功";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable(name = "studentId") Integer studentId) {
        studentService.deleteStudent(studentId);
        return "刪除成功";
    }
}
