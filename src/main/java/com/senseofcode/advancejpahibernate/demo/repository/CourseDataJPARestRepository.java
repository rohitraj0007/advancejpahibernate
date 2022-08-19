package com.senseofcode.advancejpahibernate.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.senseofcode.advancejpahibernate.demo.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseDataJPARestRepository extends JpaRepository<Course, Long> {
	List<Course> findByName(String name);
	List<Course> findAll();
 
}
