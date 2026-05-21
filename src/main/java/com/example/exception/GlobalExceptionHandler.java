package com.example.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFound(StudentNotFoundException ex,
                                        Model model,
                                        HttpServletRequest request) {
        model.addAttribute("errorMessage", ex.getMessage());
        String referer = request.getHeader("Referer");
        if(referer == null) {
            referer = "/";
        }
        model.addAttribute("backUrl", referer);
        return "error";
    }
}