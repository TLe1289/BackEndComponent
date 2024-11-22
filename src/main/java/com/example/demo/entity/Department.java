package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity

@Table(name = "departments")
public class Department{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use appropriate generation strategy
    private Long id;
    
    @Column(name = "department_id")
    private String departmentId;
    @Column(name = "building")
    private String building;
    @Column(name = "office")
    private int office;
    @Column(name = "major_offered")
    private String majorOffered;
    @Column(name = "total_hours_req")
    private int totalHoursReq;
    @Column(name = "advisor_id")
    private String advisorId;
    @Column(name = "advisor_phone")
    private int advisorPhone;


    // Getters and setters

    public String getDepartmentId() { return departmentId; }
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }

    public String getBuilding() { return building; }
    public void setBuilding(String building) {this.building = building;}

    public int getOffice() {return office;}
    public void setOffice(int office) {this.office = office; }

    public String getMajorOffered() { return majorOffered; }
    public void setMajorOffered(String majorOffered) {this.majorOffered = majorOffered;}

    public int getTotalHoursReq() {return totalHoursReq;}
    public void setTotalHoursReq(int totalHoursReq) {this.totalHoursReq = totalHoursReq; }

    public String getAdvisorID() {return advisorId;}
    public void setAdvisorID(String advisorId) {this.advisorId = advisorId;}

    public int getAdvisorPhone() {return advisorPhone;}
    public void setAdvisorPhone(int advisorPhone) {this.advisorPhone = advisorPhone;} 
}
