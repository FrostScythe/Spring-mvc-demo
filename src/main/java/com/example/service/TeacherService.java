package com.example.service;

import com.example.model.Teacher;
import com.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

//    List<Teacher> teachers = new ArrayList<>();
//
//    public TeacherService(){
//        teachers.add(new Teacher(1,"Sita","sita.rock@abra.com","Spring","Information Technology",5,25000.0));
//        teachers.add(new Teacher(2,"Geeta","geeta.rani2357@abra.com","Hibernate","Information Technology",3,25000.0));
//        teachers.add(new Teacher(3,"Babita","babita4067@abra.com","English","Literature",2,25000.0));
//        teachers.add(new Teacher(4,"Lalita","lali34ta@abra.com","Communication","Electronic and Communication",7,25000.0));
//
//    }
//
//    private int nextId =5;
//      to use this data use streams api

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

    public Teacher getTeacherById(int Id){
        return teacherRepository.findById(Id);
    }

    public void updateTeacher(int id, Teacher updated){
        teacherRepository.update(id, updated);
    }
}