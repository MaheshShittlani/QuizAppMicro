package com.learn.quiz.dto;

public class UpdateQuizRequestDto extends QuizRequestDto {

	private Long id;

	public UpdateQuizRequestDto() {
		super();
	}

	public UpdateQuizRequestDto(Long id, String title, String category) {
		super(title, category);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
