package com.example.demo.controller;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.entity.StudentCourse;
import com.example.demo.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/students")
public class StudentController{

    @Autowired
    private StudentRepository studentrepository;
    @Autowired
    private StudentCourseRepository studentcourserepository;
    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentrepository.findAll();
    }

    // Endpoint to get a student by ID -------------------THIS WORK DO NOT DELETE-----------------
    /*@GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") String id) {
        return studentrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }*/
    /*@GetMapping("/{id}")
    public List<StudentCourse> getCoursesByStudentId(@PathVariable("id") String studentId) {
        return studentcourserepository.findByStudentId(studentId);
    }*/ //----------------------------This is starting to work ----------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getStudentAndCourses(@PathVariable("id") String id) {
        // Fetch the student details
        Student student = studentrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Fetch the courses associated with the student
        List<StudentCourse> courses = studentcourserepository.findByStudentId(id);

        // Create a combined response
        Map<String, Object> response = new HashMap<>();
        response.put("student", student);
        response.put("courses", courses);

        // Return the response
        return ResponseEntity.ok(response);
    }

    // Endpoint to create a new student
    /*@PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentrepository.save(student);
    }*/

    // Endpoint to update a student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") String id, @RequestBody Student updatedStudent) {
        return studentrepository.findById(id).map(student -> {
            student.setStudentId(updatedStudent.getStudentId());
            student.setGender(updatedStudent.getGender());
            student.setMajor(updatedStudent.getMajor());
            return studentrepository.save(updatedStudent);
        }).orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    // Endpoint to delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") String id) {
        studentrepository.deleteById(id);
    }

}

