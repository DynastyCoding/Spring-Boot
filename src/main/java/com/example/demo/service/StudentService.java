package com.example.demo.service;

import com.example.demo.dto.request.CreateStudentRequest;
import com.example.demo.dto.response.StudentResponse;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentResponse createStudent(CreateStudentRequest req){
        Student po = new Student();
        po.setName(req.getName());
        po.setPassword(req.getPassword());
        po.setScore(req.getScore());
        Student saved = studentRepository.save(po);
        return toResponse(saved);
    }

    public List<StudentResponse> getAllStudents() {
        List<Student> poList = studentRepository.findAll();
        List<StudentResponse> result = new ArrayList<>();
        for (Student po : poList) result.add(toResponse(po));
        return result;
    }

    public StudentResponse getStudentById(Integer id) {
        Student po = studentRepository.findById(id).orElse(null);
        return (po != null) ? toResponse(po) : null;
    }

    public StudentResponse updateStudent(Integer id,
                                         CreateStudentRequest req){
        Student po = new Student();
        po.setId(id);
        po.setName(req.getName());
        po.setPassword(req.getPassword());
        po.setScore(req.getScore());
        return toResponse(studentRepository.save(po));
    }

    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }

    private StudentResponse toResponse(Student po){
        ScoreVO scoreVO = new ScoreVO(po.getScore());
        StudentResponse resp = new StudentResponse();
        resp.setId(po.getId());
        resp.setName(po.getName());
        resp.setScore(scoreVO.getValue());
        resp.setLetterGrade(scoreVO.getLetterGrade());
        return resp;
    }
}
