package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// JpaRepository provides basic CRUD operations for User
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT d.departmentId FROM Department d WHERE d.majorOffered = :majorOffered")
    String findDepartmentIdByMajorOffered(@Param("majorOffered") String majorOffered);
}
