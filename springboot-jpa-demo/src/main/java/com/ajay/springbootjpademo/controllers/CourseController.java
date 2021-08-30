package com.ajay.springbootjpademo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.springbootjpademo.dto.Course;
import com.ajay.springbootjpademo.dto.Topic;
import com.ajay.springbootjpademo.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping("topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "topics/{topicId}/courses")
	public ResponseEntity<String> addCourse(@PathVariable String topicId ,@RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("topics/{topicId}/courses/{courseId}")
	public Course getCourseById(@PathVariable String courseId) {
		return courseService.getCourseById(courseId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "topics/{topicId}/courses/{courseId}")
	public ResponseEntity<String> updateCourse(@PathVariable String topicId, @PathVariable String courseId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course, courseId);
		return new ResponseEntity<String>(HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "topics/{topicId}/courses/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable String courseId) {
		courseService.deleteCourse(courseId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
