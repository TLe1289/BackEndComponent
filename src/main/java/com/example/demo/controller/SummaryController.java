package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.entity.StudentCourse;
import com.example.demo.repository.StudentCourseRepository;
import com.example.demo.entity.InstructorCourse;
import com.example.demo.repository.InstructorCourseRepository;
import com.example.demo.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/Summary")
public class SummaryController{

    @Autowired
    private StudentRepository studentFolder;
    @Autowired
    private StudentCourseRepository studentcourseFolder;
    @Autowired
    private InstructorCourseRepository instructorcourseFolder;
    @Autowired
    private DepartmentRepository departmentFolder;

    @GetMapping
    public void SummaryReport(){
    List<String> Allmajors = studentFolder.findAllMajors(); 
    List<String> studentIds = studentFolder.findAllStudentIds();

    Map<String, Double> lowestGPA = new HashMap<>();
    Map<String, Double> highestGPA = new HashMap<>();
    Map<String, Double> averageGPA = new HashMap<>();
    Map<String, Double> totalGPA = new HashMap<>();
    Map<String, Integer> studentCount = new HashMap<>();

    for (String major : Allmajors) {
        // Initialize the lowest and highest GPA for this major
        lowestGPA.put(major, Double.MAX_VALUE);
        highestGPA.put(major, Double.MIN_VALUE);
        totalGPA.put(major, 0.0);
        studentCount.put(major, 0);
        averageGPA.put(major, 0.0);

        for (String studentId : studentIds) {
            String studentMajor = studentFolder.findMajorByStudentId(studentId);

            // Only process students with the current major
            if (!major.equals(studentMajor)) {
                continue;
            }

            List<StudentCourse> studentCourses = studentcourseFolder.findByStudentId(studentId);
            if (studentCourses.isEmpty()) {
                continue;
            }

            double totalGradePoints = 0.0;
            double totalCredits = 0.0;

            for (StudentCourse course : studentCourses) {
                double gradePoints = convertGradeToPoints(course.getGrade());
                int credit = instructorcourseFolder.findCreditsByCourseNumber(course.getCourseNumber());
                totalGradePoints += gradePoints * credit; // Weighted grade points
                totalCredits += credit; // Total credits
            }

            double unroundedGPA = totalGradePoints / totalCredits;
            double GPA = Math.round(unroundedGPA * 100.0) / 100.0;

            // Update the lowest and highest GPA for the current major
            lowestGPA.put(major, Math.min(lowestGPA.get(major), GPA));
            highestGPA.put(major, Math.max(highestGPA.get(major), GPA));
            totalGPA.put(major, totalGPA.get(major) + GPA);
            studentCount.put(major, studentCount.get(major) + 1);
        }
        if (studentCount.get(major) > 0) {
            double avgGPA = Math.round((totalGPA.get(major) / studentCount.get(major)) * 100.0) / 100.0;
            averageGPA.put(major, avgGPA);
        }
    }

    // Print the results
    System.out.println("Lowest and Highest GPAs by Major:");
    for (String major : Allmajors) {
        System.out.println("Major: " + major+ ", Lowest GPA: " + lowestGPA.get(major)+ ", Highest GPA: " + highestGPA.get(major)+ ", Average GPA: " + averageGPA.get(major));
    }

    List<Map.Entry<String, Double>> sortedMajors = averageGPA.entrySet()
            .stream()
            .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
            .collect(Collectors.toList());

    // Print the sorted majors and their average GPAs
    System.out.println("\n");
    System.out.println("Deparments Sorted by Average GPA:");
    for (Map.Entry<String, Double> entry : sortedMajors) {
        //String temp = departmentFolder.findDepartmentIdByMajorOffered(entry.getKey()); 
        System.out.println("Deparments: " + entry.getKey() + ", Average GPA: " + entry.getValue());
    }

    }
    /*public void SummaryReport() {
        List<String> Allmajors = studentFolder.findAllMajors(); 
        List<String> studentIds = studentFolder.findAllStudentIds();
        for (String studentId : studentIds) {
            String major = studentFolder.findMajorByStudentId(studentId);
            System.out.println("Student ID: " + studentId + ", Major: " + major);
        
            List<StudentCourse> studentCourses = studentcourseFolder.findByStudentId(studentId);
            if (studentCourses.isEmpty()) {
                continue;
            }

            double totalGradePoints = 0.0;
            double totalCredits = 0.0;

            for (StudentCourse course : studentCourses) {
                double gradePoints = convertGradeToPoints(course.getGrade());
                int credit = instructorcourseFolder.findCreditsByCourseNumber(course.getCourseNumber());
                totalGradePoints += gradePoints * (double)credit; // Weighted grade points
                totalCredits += (double)credit; // Total credits
            }
            double GPA = totalGradePoints/totalCredits;
            System.out.println("Student ID: " + studentId + ", GPA: " + GPA);
        }


    }*/

    private double convertGradeToPoints(char grade) {
        switch (Character.toUpperCase(grade)) {
            case 'A': return 4.0;
            case 'B': return 3.0;
            case 'C': return 2.0;
            case 'D': return 1.0;
            case 'F': return 0.0;
            case 'U': return 0.0;
            case 'I': return 0.0;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }
    }

}
