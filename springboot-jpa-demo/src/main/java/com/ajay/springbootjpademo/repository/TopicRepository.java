package com.ajay.springbootjpademo.repository;

import org.springframework.data.repository.CrudRepository;

import com.ajay.springbootjpademo.dto.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{

	//crudRepostory has all the methods specific to entity classes, so you dont need to create class
	//and create those methods, jpa will provide it for you.
}
