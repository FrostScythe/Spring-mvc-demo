package com.example.service;

import com.example.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();
    private int nextId = 4;

    public StudentService() {
        // order: (id, name, email, course, year)
        students.add(new Student(1, "Alice",   "alice@email.com",   "Spring MVC", 2026));
        students.add(new Student(2, "Bob",     "bob@email.com",     "Java",        2025));
        students.add(new Student(3, "Charlie", "charlie@email.com", "Hibernate",   2026));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    public List<Student> searchByName(String name) {
        return students.stream()
                .filter(s -> s.getName().toLowerCase()
                        .contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}