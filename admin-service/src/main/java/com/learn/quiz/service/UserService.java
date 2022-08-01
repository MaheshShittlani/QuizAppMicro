package com.learn.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.quiz.dto.Response;
import com.learn.quiz.dto.UpdateUserDto;
import com.learn.quiz.entity.LoginSession;
import com.learn.quiz.entity.User;
import com.learn.quiz.exceptionHandler.CustomException;
import com.learn.quiz.repository.LoginSessionDao;
import com.learn.quiz.repository.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private LoginSessionDao loginSessionDao;

	public User getUser(String authorization) {
		LoginSession loginSession = loginSessionDao.findByAccessToken(authorization.split(" ")[1]);
		if (loginSession == null) {
			throw new CustomException("Invalid access.", HttpStatus.UNAUTHORIZED);
		}
		User user = userDao.findById(loginSession.getUserId());
		if (user == null || user.getIsAdmin() == 'N') {
			throw new CustomException("Invalid access.", HttpStatus.UNAUTHORIZED);
		}
		return user;
	}

	public ResponseEntity<Response> updateProfile(UpdateUserDto updateUserDto, String authorization) {
		User user = getUser(authorization);
		user.setFirstName(updateUserDto.getFirstName());
		user.setLastName(updateUserDto.getFirstName());
		user.setMobileNumber(updateUserDto.getMobileNumber());
		if (userDao.update(user) > 0) {
			return new ResponseEntity<Response>(new Response("Profile updated successfully."), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Unable to update profile."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
