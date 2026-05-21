package com.example.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFound(StudentNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(TeacherNotFound.class)
    public String handleTeacherNotFound(TeacherNotFound ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(InvalidSearchException.class)
    public String handleInvalidSearch(InvalidSearchException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}