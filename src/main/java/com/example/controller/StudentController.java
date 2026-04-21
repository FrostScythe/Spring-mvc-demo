package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 1. VIEW ALL students
    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("total", studentService.getAllStudents().size());
        return "students/list";
    }

    // 2. SHOW ADD FORM
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student()); // empty object for form
        return "students/add";
    }

    // 3. SUBMIT ADD FORM
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/students"; // after adding, go back to list
    }

    // 4. DELETE student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    // 5. SEARCH students
    @GetMapping("/search")
    public String searchStudents(@RequestParam String name, Model model) {
        List<Student> results = studentService.searchByName(name);
        model.addAttribute("students", results);
        model.addAttribute("total", results.size());
        model.addAttribute("searchTerm", name);
        return "students/list"; // reuse same list page
    }
}