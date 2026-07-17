package com.example.demo.JDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS student" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50)";

        jdbcTemplate.execute(sql);
    }
}
