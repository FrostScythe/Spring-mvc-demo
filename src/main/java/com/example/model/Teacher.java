package com.example.model;

public class Teacher {
    private int id;
    private String name;
    private String email;
    private String subject;
    private String department;
    private int experience;
    private double salary;

    public Teacher(int id,String name , String email, String subject,String department, int experience,double salary){
        this.id=id;
        this.name = name;
        this.subject=subject;
        this.experience=experience;
        this.email =email;
        this.department=department;
        this.salary = salary;
    }

    // Default constructor — REQUIRED for form binding
    public Teacher() {}

    // getter
    public int getId(){ return id; }
    public String getName(){return name;}
    public String getSubject(){return subject;}
    public int getExperience(){return experience;}
    public String getEmail() {return email;}
    public String getDepartment() {return department;}
    public double getSalary(){return salary;}

    //setter
    public void setId(int id){this.id = id;}
    public void setName(String name){this.name= name; }
    public void setSubject(String subject){this.subject = subject;}
    public void setExperience(int experience){this.experience=experience;}
    public void setEmail(String email){this.email= email;}
    public void setDepartment(String department){this.department= department;}
    public void setSalary(double salary){this.salary=salary;}
}
