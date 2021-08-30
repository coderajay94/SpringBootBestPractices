package com.ajay.springbootdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.springbootdemo.TopicService;
import com.ajay.springbootdemo.dto.Topic;

@RestController
public class TopicController {

	@Autowired
	TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{topicId}")
	public Topic getTopicById(@PathVariable String topicId) {
		return topicService.getTopicById(topicId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public ResponseEntity<String> addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}")
	public ResponseEntity<String> updateTopic(@PathVariable String topicId, @RequestBody Topic topic){
		topicService.updateTopic(topic, topicId);
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	
	@RequestMapping(method =RequestMethod.DELETE, value="/topics/{topicId}" )
	public ResponseEntity<String> deleteTopic(@PathVariable String topicId){
		topicService.deleteTopic(topicId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
