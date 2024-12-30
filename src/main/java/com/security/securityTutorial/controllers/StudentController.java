package com.security.securityTutorial.controllers;

import com.security.securityTutorial.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final List<Student> students = Arrays.asList(
            new Student(1, "Nelly Kamenya"),
            new Student(2, "Timothy Ndegwa"),
            new Student(3, "Linda Wangari")
    );

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return students;
    }
}
