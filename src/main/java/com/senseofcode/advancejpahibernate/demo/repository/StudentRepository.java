package com.senseofcode.advancejpahibernate.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.senseofcode.advancejpahibernate.demo.entity.Passport;
import com.senseofcode.advancejpahibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	@Autowired
	EntityManager em;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			 em.persist(student);
			
		} else {
			 em.merge(student);
		}
		return student;
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	/*
	 * flush=flush will push all the changes to db which generally goes just before transaction block ends.
	 * clear will remove all the entity which is associated with entity manager
	 * detach will selectively remove only the entity which is passed and is associated with entity manager
	 * refresh refresh will pull the information from db for the particular entity and forget about the changes done till now in the entity
	 */
	public void saveStudentWithPassport() {
		Passport passpport = new Passport("27894khkf");
		em.persist(passpport);
		Student student=new Student("Sameer",passpport);
		em.persist(student);
	}
	
	public void getAll() {
		
		
	}

}
