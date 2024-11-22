package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "major")
    private String major;

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId){this.studentId = studentId;}

    public String getGender() { return gender; }
    public void setGender(String gender){this.gender = gender;}

    public String getMajor() { return major; }
    public void setMajor(String major) {this.major = major;}
}