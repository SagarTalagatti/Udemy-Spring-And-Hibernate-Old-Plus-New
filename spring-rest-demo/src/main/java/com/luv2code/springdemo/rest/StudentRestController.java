package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	// define @PostConstruct to load the student data ... ONLY ONCE!
	@PostConstruct
	public void loadData() {

		students = new ArrayList<>();

		students.add(new Student("John", "Doe"));
		students.add(new Student("Mary", "Public"));
		students.add(new Student("Madhu", "Patel"));
	}

	// define endpoint for "/students"
	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}

	// define endpoint for "/students/{studentId}"
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {

		if (students.size() < studentId || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return students.get(studentId);
	}

}
