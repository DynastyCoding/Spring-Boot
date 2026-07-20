package com.example.demo.JDBC;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/student/table")
    public String createTable(){
        studentService.createTable();
        return "Data table created successfully.";
    }

    @PostMapping("/students")
    public String create(@RequestBody Student student){
        studentService.createStudent(student);
        return "added successfully";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable(name = "studentId") Integer studentId,
                         @RequestBody Student student){
        studentService.updateStudent(studentId, student);
        return "Modification successful";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable(name = "studentId") Integer studentId){
        studentService.deleteStudent(studentId);
        return "Deletion successful";
    }

    @PostMapping("/students/batch")
    public String batchCreate(@RequestBody List<Student> list) {
        studentService.batchInsert(list);
        return "批次新增成功";
    }

    @GetMapping("/students")
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }

    @GetMapping("/students/{studentId}")
    public List<Student> getStudentById(@PathVariable(name = "studentId") Integer studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/students/search")
    public List<Student> getStudentsByIds(@RequestParam(name = "ids") List<Integer> ids) {
        return studentService.getStudentsByIds(ids);
    }
}
