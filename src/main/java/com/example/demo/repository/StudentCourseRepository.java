package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.StudentCourse;
import java.util.List;

// JpaRepository provides basic CRUD operations for StudentCourse
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    @Query("SELECT sc FROM StudentCourse sc WHERE sc.studentId = :studentId")
    List<StudentCourse> findByStudentId(@Param("studentId") String studentId);
}