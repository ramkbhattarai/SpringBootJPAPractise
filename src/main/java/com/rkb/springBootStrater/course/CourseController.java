package com.rkb.springBootStrater.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		
		
		return courseService.getAllCourses();
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable int id) {
		return courseService.getCourse(id);
	}
	
	@PostMapping("/courses")
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}
	
	@PutMapping("/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable int id) {
		courseService.update(course, id);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable int id) {
		courseService.delete(id);
	}

}
