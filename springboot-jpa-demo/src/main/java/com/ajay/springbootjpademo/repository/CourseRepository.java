package com.ajay.springbootjpademo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ajay.springbootjpademo.dto.Course;

public interface CourseRepository extends CrudRepository<Course, String> {

	// crudRepostory has all the methods specific to entity classes, so you dont
	// need to create class
	// and create those methods, jpa will provide it for you.

	public List<Course> findByTopicId(String topicId);
	
}
