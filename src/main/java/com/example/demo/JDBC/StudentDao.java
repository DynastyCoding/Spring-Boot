package com.example.demo.JDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDao {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate,NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS student" +
                     "(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50))";

        jdbcTemplate.execute(sql);
    }

    public void createStudent(Student student){
        String sql = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());

        namedParameterJdbcTemplate.update(sql, map);
    }

    public void updateStudent(Student student){
        String sql = "UPDATE student SET name = :studentName WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());

        namedParameterJdbcTemplate.update(sql, map);
    }

    public void deleteStudent(Integer studentId){
        String sql = "DELETE FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        namedParameterJdbcTemplate.update(sql, map);
    }

    public int[] batchInsert(List<Student> list) {
        String sql = "INSERT INTO student(id, name) VALUES (:id, :name)";
        List<Map<String, Object>> batchParams = new ArrayList<>();
        for (Student s : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", s.getId());
            map.put("name", s.getName());
            batchParams.add(map);
        }
        return namedParameterJdbcTemplate.batchUpdate(
                sql, batchParams.toArray(new Map[0]));
    }

    public List<Student> getStudentList(){
        String sql = "SELECT id, name FROM student";
        Map<String, Object> map = new HashMap<>();
        StudentRowMapper rowMapper = new StudentRowMapper();
        return namedParameterJdbcTemplate.query(sql, map, rowMapper);
    }

    //單一呼叫，若API或邏輯非常頻繁地被單筆呼叫，且資料量很大，
    //可單獨寫出一個方法
    public List<Student> getStudentById(Integer studentId) {
        String sql = "SELECT id, name FROM student WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        StudentRowMapper rowMapper = new StudentRowMapper();
        return namedParameterJdbcTemplate.query(sql, map, rowMapper);
    }

    //可一次呼叫多比 實務多以此為主
    public List<Student> getStudentsByIds(List<Integer> ids) {
        String sql = "SELECT id, name FROM student WHERE id IN (:ids)";
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);   // List 直接傳入，Spring JDBC 自動展開
        return namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
    }
}