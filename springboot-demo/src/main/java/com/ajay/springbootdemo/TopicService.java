package com.ajay.springbootdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.ajay.springbootdemo.dto.Topic;

@Service
public class TopicService {

	//this is mutable array list we need to convert it into immutable list
	/*private static List<Topic> topics = Arrays.asList(
			new Topic("Spring", "Spring boot starter web", "to create spring web applications"),
			new Topic("Spring boot", "Spring boot started reactive", "to create reactive spring web applications"),
			new Topic("Spring security", "Spring boot started security", "to securing spring web applications"));
*/
	
	private static List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring boot starter web", "to create spring web applications"),
			new Topic("Spring boot", "Spring boot started reactive", "to create reactive spring web applications"),
			new Topic("Spring security", "Spring boot started security", "to securing spring web applications")));

	
	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopicById(String topicId) {
		return topics.stream().filter((t)-> t.getId().equalsIgnoreCase(topicId)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String topicId) {
		
		 Topic backendTopic = topics.stream().filter(t-> t.getId().equalsIgnoreCase(topicId)).findFirst().get();
		if(backendTopic!=null) {
			backendTopic.setDescription(topic.getDescription());
			backendTopic.setName(topic.getName());
			backendTopic.setId(topic.getId());
			System.out.println("topic updated");
		}else {
			System.out.println("topic not foud for update so inserting");
			topics.add(topic);
		}
	}

	public void deleteTopic(String topicId) {
		
		topics.removeIf(t->t.getId().equalsIgnoreCase(topicId));
		
		/*
		 try {
		Topic topic = topics.stream().filter(t->t.getId().equalsIgnoreCase(topicId)).findFirst().get();
		if(null!=topic) {
			topics.remove(topic);
			System.out.println("topic deleted");
		}else {
			System.out.println("topic is not available to delete");
		}
		}
		catch(NoSuchElementException ex) {
			System.out.println("topic is not available to delete"+ex);
		}
	}
	*/
	}

}
