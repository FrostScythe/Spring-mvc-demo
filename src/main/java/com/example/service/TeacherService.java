package com.example.service;

import com.example.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    List<Teacher> teachers = new ArrayList<>();

    public TeacherService(){
        teachers.add(new Teacher(1,"Sita","sita.rock@abra.com","Spring","Information Technology",5,25000.0));
        teachers.add(new Teacher(2,"Geeta","geeta.rani2357@abra.com","Hibernate","Information Technology",3,25000.0));
        teachers.add(new Teacher(3,"Babita","babita4067@abra.com","English","Literature",2,25000.0));
        teachers.add(new Teacher(4,"Lalita","lali34ta@abra.com","Communication","Electronic and Communication",7,25000.0));

    }

    private int nextId =4;

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teacher.setId(nextId++);
        teachers.add(teacher);
    }

    public void deleteTeacher(int id){
        teachers.removeIf(t->t.getId()==id);
    }

    public void searchByName(String name){
        teachers.stream()
                .filter(s -> s.getName().toLowerCase()
                        .contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}