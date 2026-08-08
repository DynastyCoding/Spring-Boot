package com.example.demo.Class.JPA;

//@Repository
public class StudentDao {

    private final StudentRepository studentRepository;

    public StudentDao(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId){
        studentRepository.deleteById(studentId);
    }

}
