package com.server.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.resource.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
