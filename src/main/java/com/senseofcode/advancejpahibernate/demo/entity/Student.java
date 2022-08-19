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
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="name",nullable= false)
	private String name;
	@OneToOne(fetch=FetchType.LAZY)//by default it is eager to make it fast we go for lazy loading when other related entity is not required
	private Passport passport;
	@Column(name="lastUpdateDate")
	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;
	@Column(name="createdDate")
	@CreationTimestamp
	private LocalDateTime createdDate;
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + ", lastUpdateDate=" + lastUpdateDate
				+ ", createdDate=" + createdDate + "]";
	}

	public Student(String name) {
		super();
		this.name = name;
	}
	
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public Student(String name, Passport passport) {
		super();
		this.name = name;
		this.passport = passport;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
