package com.rkb.springBootStrater.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository topicRepository;
	
	public List<Course> getAllTopics(){
		List<Course> topics = new ArrayList<>();
		 topicRepository.findAll().forEach(topics::add);
		 return topics;
	}

	public Course getTopic(int id) {
		return topicRepository.findById(id).get();
	}

	public void addTopic(Course topic) {
		topicRepository.save(topic);
	}

	public void update(Course topic, int id) {
		topicRepository.save(topic);
	}

	public void delete(int id) {
		topicRepository.deleteById(id);
		
	}
}
