package com.example.ProounceTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService cs;
	
	@GetMapping("/courses/{id}")
	public ResponseStructure<Course> getCourse(@PathVariable @Valid int id) {
		
		return cs.getCourseById(id);
	}
	
	@GetMapping("/courses")
	public ResponseStructure<List<Course>> getCourses(@RequestParam int [] ids) {
		return cs.getCoursesByIds(ids);
	}
}
