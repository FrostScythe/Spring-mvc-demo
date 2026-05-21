package com.example.controller;

import com.example.exception.InvalidSearchException;
import com.example.model.Teacher;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getAllTeacher(Model model){
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers",teachers);
        model.addAttribute("total",teachers.size());
        return "teachers/list";
    }

    // SHOW ADD FORM
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("teacher",new Teacher());
        return "teachers/add";
    }

    // Submit Add Form
    @PostMapping("/add")
    public String addTeacher(@ModelAttribute Teacher teacher){
        teacherService.addTeacher(teacher);
        return "redirect:/teachers";
    }

    // Delete Teacher
    @PostMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable int id){
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam String name, Model model){
        List<Teacher> results = teacherService.searchByName(name);
        if (results != null && results.isEmpty()) {
            throw  new InvalidSearchException("No teacher found with name: " + name);
        }
        model.addAttribute("teachers",results);
        model.addAttribute("total",results.size());
        model.addAttribute("searchTerm",name);
        return "teachers/list";
    }

    //show EDIT FORM for teacher
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "teachers/edit";
    }

    @PostMapping("/edit/{id}")
    public String editTeacher(@PathVariable int id, @ModelAttribute Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return "redirect:/teachers";
    }
}
