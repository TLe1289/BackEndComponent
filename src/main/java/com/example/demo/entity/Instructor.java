package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "instructors")
public class Instructor{
    
    @Id
    @Column(name = "instructor_id")
    private String instructorId;
    @Column(name = "instructor_phone")
    private int instructorPhone;
    @Column(name = "department_id")
    private String departmentId;
    @Column(name = "hired_semester")
    private String hiredSemester;

    // Getters and Setters

    public String getInstructorId() {return instructorId;}
    public void setInstructorId(String instructorId) {this.instructorId = instructorId;}

    public int getInstructorPhone() {return instructorPhone;}
    public void setInstructorPhone(int instructorPhone) {this.instructorPhone = instructorPhone;}
    
    public String getDepartmentId() {return departmentId;}
    public void setDepartmentId(String departmentId) {this.departmentId = departmentId;}

    public String getHiredSemester() {return hiredSemester;}
    public void setHiredSemester(String hiredSemester) {this.hiredSemester = hiredSemester;}
}