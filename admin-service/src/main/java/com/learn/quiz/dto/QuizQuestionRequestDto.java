package com.learn.quiz.dto;

public class QuizQuestionRequestDto {

	private Long quizId;

	private Long questionId;

	public QuizQuestionRequestDto(Long quizId, Long questionId) {
		super();
		this.quizId = quizId;
		this.questionId = questionId;
	}

	public QuizQuestionRequestDto() {
		super();
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

}
