package com.senseofcode.advancejpahibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.senseofcode.advancejpahibernate.demo.entity.Course;
import com.senseofcode.advancejpahibernate.demo.repository.CourseRepository;
import com.senseofcode.advancejpahibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(courseRepository.findById(2001L).toString());
		//courseRepository.deleteById(2001L);
		courseRepository.addReviewsForCourse();
		logger.info(courseRepository.save(new Course("Java")).toString());
		studentRepository.saveStudentWithPassport();
		courseRepository.removeReviewsForCourse();
	}
	

}
