package com.senseofcode.advancejpahibernate.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Course")
@NamedQueries(value = { 
		@NamedQuery(name = "get_all", query = "select c from Course c") ,
		@NamedQuery(name = "get_one", query = "select c from Course c where c.id =:id")
		}
)
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="name",nullable= false)
	private String name;
	@Column(name="lastUpdateDate")
	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;
	@Column(name="createdDate")
	@CreationTimestamp
	private LocalDateTime createdDate;
	

	public Course(String name) {
		super();
		this.name = name;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
