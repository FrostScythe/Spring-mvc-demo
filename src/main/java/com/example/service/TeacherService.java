package com.example.service;

import com.example.exception.TeacherNotFound;
import com.example.model.Teacher;
import com.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(int id){
        teacherRepository.delete(id);
    }

    public List<Teacher> searchByName(String name){
        return teacherRepository.searchByName(name);
    }

    public Teacher getTeacherById(int id){
        try{
            return teacherRepository.findById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new TeacherNotFound(id);
        }
    }

    public void updateTeacher(int id, Teacher updated){
        teacherRepository.update(id, updated);
    }
}