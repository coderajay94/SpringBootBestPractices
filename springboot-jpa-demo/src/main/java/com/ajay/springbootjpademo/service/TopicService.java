package com.ajay.springbootjpademo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.springbootjpademo.dto.Topic;
import com.ajay.springbootjpademo.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();

		topicRepository.findAll().forEach(topics::add);
		return topics;

		// method reference in java8, watch it if you haven't seen topics::add
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public Topic getTopicById(String topicId) {
		return topicRepository.findById(topicId).get();
	}

	public void updateTopic(Topic topic, String topicId) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String topicId) {
		topicRepository.deleteById(topicId);

	}

}
