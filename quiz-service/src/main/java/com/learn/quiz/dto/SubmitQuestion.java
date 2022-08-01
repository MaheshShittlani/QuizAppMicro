package com.learn.quiz.dto;

public class SubmitQuestion {

	private Long quizId;

	private Long questionId;

	private Character answer;

	public SubmitQuestion(Long quizId, Long questionId, Character answer) {
		super();
		this.quizId = quizId;
		this.questionId = questionId;
		this.answer = answer;
	}

	public SubmitQuestion() {
		super();
		// TODO Auto-generated constructor stub
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

	public Character getAnswer() {
		return answer;
	}

	public void setAnswer(Character answer) {
		this.answer = answer;
	}

}
