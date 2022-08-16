package com.learn.quiz.dto;

public class UserScore {

	private String firstName;
	private String lastName;
	private Long score;

	public UserScore() {
		super();
	}

	public UserScore(String firstName, String lastName, Long score) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

}
