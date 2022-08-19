package com.senseofcode.advancejpahibernate.demo.repository;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.senseofcode.advancejpahibernate.demo.DemoApplication;
import com.senseofcode.advancejpahibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseJPARepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseJPARepository courseJPARepository;

	@Test
	public void findById_basic() {
		Optional<Course> course = courseJPARepository.findById(2001L);
		assertTrue(course.isPresent());
	}

	@Test
	public void findAllPagination() {
		PageRequest pageRequest = PageRequest.of(0,2);
		Page<Course> firstPage = courseJPARepository.findAll(pageRequest);
		logger.info("first Page {}",firstPage.getContent());
		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = courseJPARepository.findAll(secondPageable);
		logger.info("second Page {}",secondPage.getContent());
	//	List<Course> courses =new ArrayList<>();
		

	}

}
