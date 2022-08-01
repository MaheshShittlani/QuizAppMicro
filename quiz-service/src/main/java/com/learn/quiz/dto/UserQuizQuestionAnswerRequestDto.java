package com.learn.quiz.dto;

public class UserQuizQuestionAnswerRequestDto {

	private Long quizId;

	private Long quizQuestionId;

	private Character selectedOption;

	public UserQuizQuestionAnswerRequestDto(Long quizId, Long quizQuestionId, Character selectedOption) {
		super();
		this.quizId = quizId;
		this.quizQuestionId = quizQuestionId;
		this.selectedOption = selectedOption;
	}

	public UserQuizQuestionAnswerRequestDto() {
		super();
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
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

}
