package com.server.resource.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.resource.exceptions.CourseNotFoundException;
import com.server.resource.model.Course;
import com.server.resource.repository.CourseRepository;

@RestController
public class CourseController {

	private final CourseRepository repository;

	public CourseController(CourseRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/course")
	public List<Course> all() {
		return repository.findAll();
	}

	@PostMapping("/course")
	public Course newCourse(@RequestBody Course newCourse) {
		return repository.save(newCourse);
	}

	@GetMapping("/course/{id}")
	public Course one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
	}

	@PutMapping("/course/{id}")
	public Course replaceCourse(@RequestBody Course newCourse, @PathVariable Long id) {
		return repository.findById(id).map(course -> {
			course.setName(newCourse.getName());
			return repository.save(course);
		}).orElseGet(() -> {
			newCourse.setId(id);
			return repository.save(newCourse);
		});
	}

	@DeleteMapping("/course/{id}")
	public void deleteCourse(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
