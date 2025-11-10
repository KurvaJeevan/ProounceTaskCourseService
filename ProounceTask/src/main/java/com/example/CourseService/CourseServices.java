package com.example.CourseService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServices {
	ResponseStructure<Course> rs = new ResponseStructure<Course>();
	@Autowired
	private CouseManager c;
	

	public ResponseEntity<ResponseStructure<Course>> getCourseById(int id) {
		// TODO Auto-generated method stub
	

		List<Course> courselist = c.getCourses();

		for (Course course : courselist) {
			if (course.getCourseId() == id) {
				rs.setMessage("Course Found Successfully");
				rs.setValue(course);
				rs.setStatuscode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Course>>(rs,HttpStatus.OK);
			}
		}
		rs.setMessage("Course Not Found");
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setValue(null);
		return new ResponseEntity<ResponseStructure<Course>>(rs,HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<List<Course>>> getCoursesByIds(int[] ids) {
		// TODO Auto-generated method stub
		ResponseStructure<List<Course>> rs = new ResponseStructure<List<Course>>();
		CouseManager c = new CouseManager();
		List<Course> newcourselist = new ArrayList<Course>();
		List<Course> courselist = c.getCourses();
		for (int i = 0; i < ids.length; i++) {
			for (Course course : courselist) {

				if (course.getCourseId() == ids[i]) {
					
					newcourselist.add(course);
				}
			}
		}

		rs.setMessage("Courses found");
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setValue(newcourselist);
		return new ResponseEntity<ResponseStructure<List<Course>>>(rs,HttpStatus.OK);

	}

}
