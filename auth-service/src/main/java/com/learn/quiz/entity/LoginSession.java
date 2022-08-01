package com.learn.quiz.entity;

import java.util.Date;

public class LoginSession {

	private Long id;

	private Long userId;

	private String accessToken;

	private Date lastAccess;

	public LoginSession() {
	}

	public LoginSession(Long id, Long userId, String accessToken, Date lastAccess) {
		super();
		this.id = id;
		this.userId = userId;
		this.accessToken = accessToken;
		this.lastAccess = lastAccess;
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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

}
