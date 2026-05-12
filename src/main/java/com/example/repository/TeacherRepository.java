package com.example.repository;

import com.example.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeacherRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Teacher> rowMapper = new RowMapper<Teacher>() {
        @Override
        public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Teacher(
            rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("subject"),
                    rs.getString("department"),
                    rs.getInt("experience"),
                    rs.getDouble("salary")
            );
        }
    };

    public Teacher findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM teachers WHERE id=?",
                rowMapper, id
        );
    }

    public void save(Teacher t) {
        jdbcTemplate.update(
                "INSERT INTO teachers (name, email, subject, department, experience, salary) VALUES (?,?,?,?,?,?)",
                t.getName(), t.getEmail(), t.getSubject(), t.getDepartment(), t.getExperience(), t.getSalary()
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM teachers WHERE id=?", id);
    }

    public Teacher update(int id, Teacher t) {
        jdbcTemplate.update(
                "UPDATE teachers SET name=?, email=?, subject=?, department=?, experience=?, salary=? WHERE id=?",
                t.getName(), t.getEmail(), t.getSubject(), t.getDepartment(), t.getExperience(), t.getSalary(), id
        );
        return t;
    }

    public java.util.List<Teacher> findAll() {
        return jdbcTemplate.query("SELECT * FROM teachers", rowMapper);
    }

    public List<Teacher> searchByName(String name) {
        return jdbcTemplate.query(
                "SELECT * FROM teachers WHERE LOWER(name) LIKE ?",
                rowMapper,
                "%" + name.toLowerCase() + "%"
        );
    }
}