package com.learn.quiz.dto;

public class UpdateQuestionRequestDto extends QuestionRequestDto {

	private Long id;

	public UpdateQuestionRequestDto() {
		super();
	}

	public UpdateQuestionRequestDto(String question, String optionA, String optionB, String optionC, String optionD,
			Character rightOption, Long id) {
		super(question, optionA, optionB, optionC, optionD, rightOption);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
