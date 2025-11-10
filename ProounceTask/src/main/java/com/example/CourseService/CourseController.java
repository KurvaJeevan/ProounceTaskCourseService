package com.example.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class CourseController {
	
	@Autowired
	private CourseServices cs;
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<ResponseStructure<Course>> getCourse(@PathVariable @Valid int id) {
		
		return cs.getCourseById(id);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<ResponseStructure<List<Course>>> getCourses(@RequestParam int [] ids) {
		return cs.getCoursesByIds(ids);
	}
}
