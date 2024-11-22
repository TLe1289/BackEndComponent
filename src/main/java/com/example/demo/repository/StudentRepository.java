package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    // Custom query methods can be added here (optional)

    @Query("SELECT s.major FROM Student s WHERE s.studentId = :studentId")
    String findMajorByStudentId(@Param("studentId") String studentId);

    @Query("SELECT DISTINCT s.major FROM Student s")
    List<String> findAllMajors();

    @Query("SELECT s.studentId FROM Student s")
    List<String> findAllStudentIds();
}