package com.senseofcode.advancejpahibernate.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.senseofcode.advancejpahibernate.demo.entity.Course;

import ch.qos.logback.classic.LoggerContext;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	EntityManager em;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public Course save(Course course) {
		if (course.getId() == null) {
			 em.persist(course);
			
		} else {
			 em.merge(course);
		}
		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	/*
	 * flush=flush will push all the changes to db which generally goes just before transaction block ends.
	 * clear will remove all the entity which is associated with entity manager
	 * detach will selectively remove only the entity which is passed and is associated with entity manager
	 * refresh refresh will pull the information from db for the particular entity and forget about the changes done till now in the entity
	 */
	public void playWithEntityManager() {
		Course course = new Course("Entity Manager");
		em.persist(course);//the change is with entity manager
		//as entity persist the hibernate sequence creates an id
		course.setName("em");//the change is with entity manager
		em.flush();//db is updated with change query fired
		Course course1 = new Course("Entity Manager and percist");
		em.persist(course1);//the change is with entity manager
		em.flush();//db is updated with change query fired
		course.setName("emp");//the change is with entity manager
		em.flush();//db is updated with change query fired
		em.detach(course);//course is removed from em
		course.setName("em & p");//the change is not registered as course is not attached to em
		course1.setName("em and p");//the change is registered as course1 is not attached to em
		em.flush();//the change is committed to db only for course1
		Course course2 = new Course("Entity Manager & clear");
		em.persist(course2);//the change is with entity manager
		em.flush();//db is updated with change query fired
		course2.setName("emp & c");//the change is with entity manager
		em.refresh(course2);//now em is attached to updated entity by db record
		em.flush();//db is not updated so no change query will be fired
		course2.setName("emp & c");//the change is with entity manager
		em.clear();//all the entity is removed from em
		em.flush();// no change is registered
	}
	
	public void getAll() {
		logger.info("Object"+em.createNativeQuery("Select * from Course").getResultList().toString());
		logger.info("value"+em.createNamedQuery("get_all",Course.class).getResultList().toString());
		logger.info("value"+em.createNamedQuery("get_one",Course.class).setParameter("id", 2002L).getResultList().toString());
		
	}

}
