package com.example.exception;

public class TeacherNotFound extends RuntimeException {
    public TeacherNotFound(int id) {
        super("Teacher not found with id: " + id);
    }
}
