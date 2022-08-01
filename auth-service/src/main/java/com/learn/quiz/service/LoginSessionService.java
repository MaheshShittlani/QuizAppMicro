package com.learn.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.quiz.dto.Response;
import com.learn.quiz.repository.LoginSessionDao;

@Service
public class LoginSessionService {

	@Autowired
	private LoginSessionDao loginSessionDao;

	public ResponseEntity<Response> logout(String authToken) {
		if (loginSessionDao.deleteByAccessToken(authToken.split(" ")[1]) >= 1) {
			return new ResponseEntity<Response>(new Response("Logout successfully"), HttpStatus.OK);
		}
		return new ResponseEntity<Response>(new Response("Logout error"), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
