package com.learn.quiz.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Quiz {

	private Long id;

	private String title;

	private String category;

	@JsonIgnore
	private Character deleted = 'N';

	@JsonIgnore
	private Date createdOn = new Date();

	@JsonIgnore
	private Date updatedOn = new Date();

	public Quiz() {
		super();
	}

	public Quiz(Long id, String title, String category, Character deleted, Date createdOn, Date updatedOn) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.deleted = deleted;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Character getDeleted() {
		return deleted;
	}

	public void setDeleted(Character deleted) {
		this.deleted = deleted;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
