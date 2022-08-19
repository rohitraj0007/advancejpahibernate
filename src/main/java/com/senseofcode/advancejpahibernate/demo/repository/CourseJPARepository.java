package com.senseofcode.advancejpahibernate.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senseofcode.advancejpahibernate.demo.entity.Course;

public interface CourseJPARepository extends JpaRepository<Course, Long> {


}
