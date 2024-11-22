package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.InstructorCourse;
import com.example.demo.entity.StudentCourse;

// JpaRepository provides basic CRUD operations for InstructorCourse
public interface InstructorCourseRepository extends JpaRepository<InstructorCourse, Long> {
    // Custom query methods can be added here (optional)
    @Query("SELECT ic FROM InstructorCourse ic WHERE ic.instructorId = :instructorId")
    List<InstructorCourse> findByInstructorId(@Param("instructorId") String instructorId);

    @Query("SELECT ic.credits FROM InstructorCourse ic WHERE ic.courseNumber = :courseNumber")
    Integer findCreditsByCourseNumber(@Param("courseNumber") int courseNumber);
}
