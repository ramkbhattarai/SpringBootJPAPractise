package com.rkb.springBootStrater.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic(1, "spring framework", "spring framework description"),
			new Topic(2, "java", "java framework description"),
			new Topic(3, "javascript", "javascript framework description"),
			new Topic(4, "angular", "angular framework description")
			));
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		 topicRepository.findAll().forEach(topics::add);
		 return topics;
	}

	public Topic getTopic(int id) {
		return topics.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void update(Topic topic, int id) {
		
		Topic t1 = topics.stream().filter(t -> t.getId() == id).findFirst().get();
		t1.setDescription(topic.getDescription());
		t1.setName(topic.getName());
		
	}

	public void delete(int id) {
		topics.removeIf(t -> t.getId() == id);
		
	}
}
