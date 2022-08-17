package com.senseofcode.advancejpahibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.senseofcode.advancejpahibernate.demo.DemoApplication;
import com.senseofcode.advancejpahibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= DemoApplication.class)
public class CourseRepositoryTest {

	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void findById_basic() {
		Course course =	courseRepository.findById(2002L);
		assertEquals("Math",course.getName());

	}
	
	@Test
	@DirtiesContext//spring will reset the data because of this annotation
	public void deleteById_basic() {
		courseRepository.deleteById(1L);
		Course course =	courseRepository.findById(1L);
		assertNull(course, "null as course is deleted");

	}
	@Test
	@DirtiesContext
	public void playWithEmTest() {
		courseRepository.playWithEntityManager();
	}
	
	@Test
	public void getAllTest() {
		courseRepository.getAll();
	}

}
