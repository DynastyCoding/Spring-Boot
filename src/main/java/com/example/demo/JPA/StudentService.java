package com.example.demo.JPA;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void createStudent(Student student) {
        studentDao.createStudent(student);
    }

    public void deleteStudent(Integer studentId) {
        studentDao.deleteStudent(studentId);
    }

    public void updateStudent(Integer studentId, Student student) {
        // URL 的 id 設回 student 物件
        student.setId(studentId);

        // id 有值 → Dao 的 save() 執行 UPDATE
        studentDao.updateStudent(student);
    }
}