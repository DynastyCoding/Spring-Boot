package com.example.demo.Class.JDBC;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public void createTable(){
        studentDao.createTable();
    }

    public void createStudent(Student student){
        studentDao.createStudent(student);
    }

    public void deleteStudent(Integer studentId){
        studentDao.deleteStudent(studentId);
    }

    public void updateStudent(Integer studentId, Student student){
        student.setId(studentId);
        studentDao.updateStudent(student);
    }

    public void batchInsert(List<Student> list) {
        studentDao.batchInsert(list);
    }

    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }

    public List<Student> getStudentById(Integer studentId) {
        return studentDao.getStudentById(studentId);
    }

    public List<Student> getStudentsByIds(List<Integer> ids) {
        return studentDao.getStudentsByIds(ids);
    }
}
