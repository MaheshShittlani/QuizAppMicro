package com.learn.quiz.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class QuizQuestion {

	private Long id;

	private Long quizId;

	private Long questionId;

	@JsonIgnore
	private Character deleted = 'N';

	@JsonIgnore
	private Date createdOn = new Date();

	@JsonIgnore
	private Date updatedOn = new Date();

	public QuizQuestion(Long id, Long quizId, Long questionId, Character deleted, Date createdOn, Date updatedOn) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.questionId = questionId;
		this.deleted = deleted;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public QuizQuestion() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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
