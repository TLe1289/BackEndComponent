package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "studentcourse")
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use appropriate generation strategy
    private Long id;


    @Column(name = "student_id")
    private String studentId;
    @Column(name = "course_prefix")
    private String coursePrefix;
    @Column(name = "course_number")
    private int courseNumber;
    @Column(name = "semester")
    private String semester;
    @Column(name = "year_taken")
    private int yearTaken;
    @Column(name = "grade")
    private char grade;

    // Getters and Setters

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCoursePrefix() {
        return coursePrefix;
    }

    public void setCoursePrefix(String coursePrefix) {
        this.coursePrefix = coursePrefix;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYearTaken() {
        return yearTaken;
    }

    public void setYearTaken(int yearTaken) {
        this.yearTaken = yearTaken;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
