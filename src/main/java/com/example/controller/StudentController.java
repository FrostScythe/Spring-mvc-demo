package com.example.controller;

import com.example.exception.InvalidSearchException;
import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // VIEW ALL students
    @GetMapping
    public String getAllStudents(Model model) {
        List<Student>allStudents = studentService.getAllStudents();
        model.addAttribute("students", allStudents);
        model.addAttribute("total", allStudents.size());
        return "students/list";
    }

    // SHOW ADD FORM
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student()); // empty object for form
        return "students/add";
    }

    // SUBMIT ADD FORM
    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "students/add"; // show form again with errors
        }
        studentService.addStudent(student);
        return "redirect:/students"; // after adding, go back to list
    }

    // DELETE student
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    // SEARCH students
    @GetMapping("/search")
    public String searchStudents(@RequestParam String name, Model model) {
        List<Student> results = studentService.searchByName(name);
        if (results != null && results.isEmpty()) {
            throw  new InvalidSearchException("No student found with name: " + name);
        }
        model.addAttribute("students", results);
        model.addAttribute("total", results.size());
        model.addAttribute("searchTerm", name);
        return "students/list";
    }

    //show EDIT FORM students
    @GetMapping("/edit/{id}")
    public String showEditStudents(@PathVariable int id,Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "students/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable int id , @ModelAttribute Student student){
        studentService.updateStudent(id,student);
        return "redirect:/students";
    }
}