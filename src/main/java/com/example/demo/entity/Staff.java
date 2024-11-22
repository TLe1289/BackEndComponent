package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Entity
@Table(name = "staffs")

public class Staff{


    @Id
    @Column(name = "staff_id")
    private String staffId;
    @Column(name = "department_id")
    private String departmentId;
    @Column(name = "phone")
    private int phone;

    // Getters and Setters
    public String getStaffId() {return staffId;}
    public void setStaffId(String staffId) {this.staffId = staffId;}

    public String getDepartmentId() {return departmentId;}
    public void setDepartmentId(String departmentId) {this.departmentId = departmentId;}

    public int getPhone() {return phone;}
    public void setPhone(int phone) {this.phone = phone;}
}