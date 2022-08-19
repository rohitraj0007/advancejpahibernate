package com.senseofcode.advancejpahibernate.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Review")
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable= false)
	private String rating;
	
	private String description;
	
	@Column(name="lastUpdateDate")
	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;
	@Column(name="createdDate")
	@CreationTimestamp
	private LocalDateTime createdDate;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}
	public Review(String rating) {
		super();
		this.rating = rating;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + ", lastUpdateDate="
				+ lastUpdateDate + ", createdDate=" + createdDate + "]";
	}
	
	

}
