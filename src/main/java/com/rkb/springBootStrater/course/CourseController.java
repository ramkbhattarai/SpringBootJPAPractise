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

import com.rkb.springBootStrater.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable int topicId) {
		
		
		return courseService.getAllCourses(topicId);
	}
	
	@GetMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		return courseService.getCourse(courseId);
	}
	
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable int topicId) {
		course.setTopic(new Topic(topicId, "",""));
		courseService.addCourse(course);
	}
	
	@PutMapping("/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable int topicId) {
		course.setTopic(new Topic(topicId, "",""));
		courseService.update(course);
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable int courseId) {
		courseService.delete(courseId);
	}

}
