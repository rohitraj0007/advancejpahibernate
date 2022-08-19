package com.senseofcode.advancejpahibernate.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="Passport")
public class Passport {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable= false)
	private String number;
	//to make onetoone bidirectional and also not saving one extra column in passport we use mapped by in pair with one to one
	//if we will removed mapped by one extra column get added to passport table
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	private Student student;
	@Column(name="lastUpdateDate")
	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;
	@Column(name="createdDate")
	@CreationTimestamp
	private LocalDateTime createdDate;
	public Long getId() {
		return id;
	}
	public Passport(String number) {
		super();
		this.number = number;

	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", lastUpdateDate="
				+ lastUpdateDate + ", createdDate=" + createdDate + "]";
	}
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
