package com.rkb.springBootStrater.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(int id){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(id)
		.forEach(courses::add);
		 return courses;
	}

	public Course getCourse(int id) {
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void update(Course course, int id) {
		courseRepository.save(course);
	}

	public void delete(int id) {
		courseRepository.deleteById(id);
		
	}
}
