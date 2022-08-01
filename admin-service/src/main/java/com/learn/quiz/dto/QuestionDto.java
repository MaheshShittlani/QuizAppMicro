package com.learn.quiz.dto;

public class QuestionDto {

	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private Character rightOption;

	public QuestionDto(String question, String optionA, String optionB, String optionC, String optionD,
			String rightOption) {
		super();
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		if (rightOption != null && rightOption.length() > 0)
			this.rightOption = rightOption.charAt(0);
	}

	public QuestionDto() {
		super();
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

}
