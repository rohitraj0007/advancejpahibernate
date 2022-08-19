package com.senseofcode.advancejpahibernate.demo.repository;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.senseofcode.advancejpahibernate.demo.DemoApplication;
import com.senseofcode.advancejpahibernate.demo.entity.Passport;
import com.senseofcode.advancejpahibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= DemoApplication.class)
public class StudentRepositoryTest {

	private Logger logger =LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@Test
	@DirtiesContext
	public void StudentWithPassportTest() {
		studentRepository.saveStudentWithPassport();
	}
	
	@Test
	@Transactional
	public void findById() {
		Student student =studentRepository.findById(3L);
		logger.info(student.toString());
		logger.info(student.getPassport().toString());
		
	}
	

	@Test
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)//any of 4 levels
	public void findByIdBidirectional() {
		Passport passport = em.find(Passport.class, 60001L);
		logger.info("testing result  :"+passport.toString());
		logger.info(passport.getStudent().toString());
		
	}
	
	

}
