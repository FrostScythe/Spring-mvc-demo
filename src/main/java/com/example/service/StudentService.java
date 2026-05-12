package com.example.service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    //private List<Student> students = new ArrayList<>();
    //private int nextId = 4;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    public StudentService() {
//        // order: (id, name, email, course, year)
//        students.add(new Student(1, "Alice",   "alice@email.com",   "Spring MVC", 2026));
//        students.add(new Student(2, "Bob",     "bob@email.com",     "Java",        2025));
//        students.add(new Student(3, "Charlie", "charlie@email.com", "Hibernate",   2026));
//    }
//      to use this data use streams api

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.delete(id);
    }

    public List<Student> searchByName(String name) {
        return studentRepository.findAll().stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void updateStudent(int id, Student updated) {
        studentRepository.update(id, updated);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }
}