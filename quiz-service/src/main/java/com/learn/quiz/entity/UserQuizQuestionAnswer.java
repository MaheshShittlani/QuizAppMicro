package com.learn.quiz.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserQuizQuestionAnswer {

	private Long id;

	private Long userId;

	private Long quizQuestionId;

	private Character selectedOption;

	@JsonIgnore
	private Date createdOn = new Date();

	public UserQuizQuestionAnswer(Long id, Long userId, Long quizQuestionId, Character selectedOption, Date createdOn) {
		super();
		this.id = id;
		this.userId = userId;
		this.quizQuestionId = quizQuestionId;
		this.selectedOption = selectedOption;
		this.createdOn = createdOn;
	}

	public UserQuizQuestionAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getQuizQuestionId() {
		return quizQuestionId;
	}

	public void setQuizQuestionId(Long quizQuestionId) {
		this.quizQuestionId = quizQuestionId;
	}

	public Character getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(Character selectedOption) {
		this.selectedOption = selectedOption;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
