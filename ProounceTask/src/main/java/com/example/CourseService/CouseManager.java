package com.example.CourseService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CouseManager {
	private List<Course> courses;

	@Override
	public String toString() {
		return "CouseManager [courses=" + courses + "]";
	}

	public CouseManager(List<Course> courses) {
		super();
		this.courses = courses;
	}

	public List<Course> getCourses() {
		if(courses==null) {
			courses = new ArrayList<Course>();
		}
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public CouseManager() {
		// TODO Auto-generated constructor stub
		Course c= new Course(1,"java Fullstack",10000);
		Course c2= new Course(2,"python Fullstack",10000);
		Course c3= new Course(3,"Testing",10000);
		courses=new ArrayList<Course>();
		courses.add(c);
		courses.add(c2);
		courses.add(c3);
		
	}
}
