package com.example.demo.JDBC;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public void createTable(){
        studentDao.createTable();
    }
}
