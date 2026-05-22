package com.example.controller;

import com.example.exception.InvalidSearchException;
import com.example.model.Teacher;
import com.example.service.TeacherService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    // Constructor Injection
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // Show all teachers
    @GetMapping
    public String getAllTeacher(Model model) {
        List<Teacher> teachers = teacherService.getAllTeachers();

        model.addAttribute("teachers", teachers);
        model.addAttribute("total", teachers.size());

        return "teachers/list";
    }

    // Show Add Form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teachers/add";
    }

    // Submit Add Form
    @PostMapping("/add")
    public String addTeacher(
            @Valid @ModelAttribute Teacher teacher,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "teachers/add";
        }

        teacherService.addTeacher(teacher);
        return "redirect:/teachers";
    }

    // Delete Teacher
    @PostMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }

    // Search Teacher by Name
    @GetMapping("/search")
    public String searchTeachers(
            @RequestParam String name,
            Model model
    ) {

        List<Teacher> results = teacherService.searchByName(name);

        if (results == null || results.isEmpty()) {
            throw new InvalidSearchException(
                    "No teacher found with name: " + name
            );
        }

        model.addAttribute("teachers", results);
        model.addAttribute("total", results.size());
        model.addAttribute("searchTerm", name);

        return "teachers/list";
    }

    // Show Edit Form
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable int id,
            Model model
    ) {

        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);

        return "teachers/edit";
    }

    // Update Teacher
    @PostMapping("/edit/{id}")
    public String editTeacher(
            @PathVariable int id,
            @ModelAttribute Teacher teacher
    ) {

        teacherService.updateTeacher(id, teacher);
        return "redirect:/teachers";
    }
}