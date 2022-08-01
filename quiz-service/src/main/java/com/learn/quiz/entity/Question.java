package com.learn.quiz.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Question {

	private Long id;

	private String question;

	private String optionA;

	private String optionB;

	private String optionC;

	private String optionD;

	private Character rightOption;

	@JsonIgnore
	private Character deleted = 'N';

	@JsonIgnore
	private Date createdOn = new Date();

	@JsonIgnore
	private Date updatedOn = new Date();

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(Long id, String question, String optionA, String optionB, String optionC, String optionD,
			Character rightOption, Character deleted, Date createdOn, Date updatedOn) {
		super();
		this.id = id;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.rightOption = rightOption;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public Character getRightOption() {
		return rightOption;
	}

	public void setRightOption(Character rightOption) {
		this.rightOption = rightOption;
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
