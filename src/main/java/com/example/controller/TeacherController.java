package com.example.controller;

import com.example.model.Teacher;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping
    public String getAllTeacher(Model model){
        model.addAttribute("teachers",teacherService.getAllTeachers());
        model.addAttribute("total",teacherService.getAllTeachers().size());
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
        teacherService.addTeacher();

    }
}
