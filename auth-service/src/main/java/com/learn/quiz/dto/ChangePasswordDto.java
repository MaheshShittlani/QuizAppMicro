package com.learn.quiz.dto;

public class ChangePasswordDto {

	private String currentPassword;
	private String newPassword;
	private String retypePassword;

	public ChangePasswordDto() {
		super();
	}

	public ChangePasswordDto(String currentPassword, String newPassword, String retypePassword) {
		super();
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
		this.retypePassword = retypePassword;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
}
