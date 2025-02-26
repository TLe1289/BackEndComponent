package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, String> {
    // Custom query methods can be added here (optional)
}