package com.example.ProounceTask;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	ResponseStructure<Course> rs = new ResponseStructure<Course>();
	@Autowired
	private CouseManager c;
	

	public ResponseStructure<Course> getCourseById(int id) {
		// TODO Auto-generated method stub
	

		List<Course> courselist = c.getCourses();

		for (Course course : courselist) {
			if (course.getCourseId() == id) {
				rs.setMessage("Course Found Successfully");
				rs.setValue(course);
				rs.setStatuscode(HttpStatus.OK.value());
				return rs;
			}
		}
		rs.setMessage("Course Not Found");
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setValue(null);
		return rs;

	}

	public ResponseStructure<List<Course>> getCoursesByIds(int[] ids) {
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
//		rs.setMessage("Course Found Successfully");
//		rs.setValue(course);
//		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Courses found");
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setValue(newcourselist);
		return rs;

	}

}
