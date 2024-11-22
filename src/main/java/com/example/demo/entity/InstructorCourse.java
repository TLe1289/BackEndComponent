package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "instructorcourse")
public class InstructorCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use appropriate generation strategy
    private Long id;
    
    @Column(name = "instructor_id")
    private String instructorId;
    @Column(name = "course_prefix")
    private String coursePrefix;
    @Column(name = "course_number")
    private int courseNumber;
    @Column(name = "credits")
    private int credits;
    @Column(name = "semester")
    private String semester;
    @Column(name = "year_taught")
    private int yearTaught;

    // Getters and Setters

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYearTaught() {
        return yearTaught;
    }

    public void setYearTaught(int yearTaught) {
        this.yearTaught = yearTaught;
    }
}
