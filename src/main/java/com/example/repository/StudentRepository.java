package com.example.repository;

import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper — tells Spring how to convert one DB row → Student object
    private final RowMapper<Student> rowMapper = new RowMapper<Student>() {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course"),
                    rs.getInt("year")
            );
        }
    };

    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM students", rowMapper);
    }

    public List<Student> searchByName(String name) {
        return jdbcTemplate.query(
                "SELECT * FROM students WHERE LOWER(name) LIKE ?",
                rowMapper,
                "%" + name.toLowerCase() + "%"
        );
    }

    public void save(Student s) {
        jdbcTemplate.update(
                "INSERT INTO students (name, email, course, year) VALUES (?,?,?,?)",
                s.getName(), s.getEmail(), s.getCourse(), s.getYear()
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM students WHERE id=?", id);
    }

    public Student findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM students WHERE id=?",
                rowMapper, id
        );
    }

    public void update(int id, Student s) {
        jdbcTemplate.update(
                "UPDATE students SET name=?, email=?, course=?, year=? WHERE id=?",
                s.getName(), s.getEmail(), s.getCourse(), s.getYear(), id
        );
    }
}