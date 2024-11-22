package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Instructor;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.entity.InstructorCourse;
import com.example.demo.repository.InstructorCourseRepository;



@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired
    private InstructorCourseRepository instructorcourserepository;

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getInstructorAndCourses(@PathVariable("id") String id) {
    // Fetch the instructor details
    Instructor instructor = instructorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));

    // Fetch the courses associated with the instructor
    List<InstructorCourse> courses = instructorcourserepository.findByInstructorId(id);

    // Create a combined response
    Map<String, Object> response = new HashMap<>();
    response.put("instructor", instructor);
    response.put("courses", courses);

    // Return the response
    return ResponseEntity.ok(response);
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor newInstructor) {
        return instructorRepository.save(newInstructor);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable String id, @RequestBody Instructor updatedInstructor) {
        return instructorRepository.findById(id).map(existing -> {
            existing.setInstructorId(updatedInstructor.getInstructorId());
            existing.setInstructorPhone(updatedInstructor.getInstructorPhone());
            existing.setDepartmentId(updatedInstructor.getDepartmentId());
            existing.setHiredSemester(updatedInstructor.getHiredSemester());
            return instructorRepository.save(updatedInstructor);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteInstructor(@PathVariable String id) {
        instructorRepository.deleteById(id);
        return "Instructor with ID " + id + " deleted.";
    }


}