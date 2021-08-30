package com.ajay.springbootjpademo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.springbootjpademo.dto.Course;
import com.ajay.springbootjpademo.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAllCourses(String id) {

		List<Course> courses = new ArrayList<>();

		courses = courseRepository.findByTopicId(id);
		return courses;

		// method reference in java8, watch it if you haven't seen Courses::add
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public Course getCourseById(String CourseId) {
		return courseRepository.findById(CourseId).get();
	}

	public void updateCourse(Course Course, String CourseId) {
		courseRepository.save(Course);
	}

	public void deleteCourse(String courseId) {
		courseRepository.deleteById(courseId);

	}

}
